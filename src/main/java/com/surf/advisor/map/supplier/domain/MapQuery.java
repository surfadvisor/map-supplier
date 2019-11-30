package com.surf.advisor.map.supplier.domain;

import com.surf.advisor.map.supplier.web.api.model.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@Builder
public class MapQuery {

    private Rectangle rectangle;
    private PointCoords center;
    private Integer radius;

    private PointCoords referenceLocation;

    private Set<ObjectType> objectTypes;

    private List<ObjectStatus> status;

    private List<CountryCode> country;
    private List<SpotFacility> facilities;
    private List<Difficulty> difficulty;
    private List<Depth> depth;
    private List<SportType> sportTypes;
    private List<WaterType> waterType;
    private List<Integer> waveAvgPeriod;
    private List<Integer> waveAvgSize;

}
