package com.surf.advisor.map.supplier.service;

import com.surf.advisor.map.supplier.domain.RectangleMapQuery;
import com.surf.advisor.map.supplier.web.api.model.MapSupplierResponse;

public interface IMapSupplier {

    MapSupplierResponse queryRectangle(RectangleMapQuery query);

}
