package com.surf.advisor.map.supplier.util;

import static java.lang.Math.abs;
import static org.apache.commons.math3.util.Precision.round;

import com.google.common.collect.ImmutableMap;
import com.surf.advisor.map.supplier.web.api.model.PointCoords;
import com.surf.advisor.map.supplier.web.api.model.Rectangle;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class GridSnapUtils {

    private static final Map<Double, DoubleUnaryOperator> SIZE_QUANTIZE_FUNCTION_INIT =
        ImmutableMap.<Double, DoubleUnaryOperator>builder()
            .put(0.00, x -> round(x, 3))
            .put(0.01, x -> round(x, 2))
            .put(0.1, x -> round(x * 20.0, 0) / 20.0)
            .put(0.5, x -> round(x, 1))
            .put(1.0, x -> round(x * 5.0, 0) / 5.0)
            .put(2.0, x -> round(x * 4.0, 0) / 4.0)
            .put(5.0, x -> round(x * 2.0, 0) / 2.0)
            .put(10.0, x -> round(x, 0))
            .put(20.0, x -> round(x / 2.0, 0) * 2.0)
            .put(40.0, x -> round(x / 5.0, 0) * 5.0)
            .put(70.0, x -> round(x / 10.0, 0) * 10.0)
            .build();

    private static final TreeMap<Double, DoubleUnaryOperator> SIZE_QUANTIZE_FUNCTION
        = new TreeMap<>(SIZE_QUANTIZE_FUNCTION_INIT);

    private static final double CELL_SIZE_RATIO = 0.1;

    private static final Map<PointGetter, PointSetter> POINT_OPERATORS = Map.of(
        PointCoords::getLatitude, PointCoords::setLatitude,
        PointCoords::getLongitude, PointCoords::setLongitude
    );


    public static void snapToGrid(Rectangle rectangle) {

        var a = rectangle.getPointA();
        var b = rectangle.getPointB();

        double size = getAvgRectangleQuerySize(a, b);
        size = quantizeSize(size);

        double cellSize = size * CELL_SIZE_RATIO;

        Stream.of(a, b).forEach(point ->
            POINT_OPERATORS.forEach((get, set) -> {
                double x = get.apply(point);
                double quantized = round(x / cellSize, 0) * cellSize;
                set.accept(point, quantized);
            }));
    }

    private static double getAvgRectangleQuerySize(PointCoords a, PointCoords b) {

        double latDiff = abs(a.getLatitude() - b.getLatitude());
        double lonDiff = abs(a.getLongitude() - b.getLongitude());

        double result = (latDiff + lonDiff) / 2.0;
        log.debug("Average rectangle query size: {}", result);

        return result;
    }

    private double quantizeSize(double size) {
        double result = SIZE_QUANTIZE_FUNCTION.floorEntry(size).getValue().applyAsDouble(size);

        log.debug("Size quantized: {} -> {}", size, result);
        return result;
    }

    private interface PointGetter extends Function<PointCoords, Double> {

    }

    private interface PointSetter extends BiConsumer<PointCoords, Double> {

    }
}
