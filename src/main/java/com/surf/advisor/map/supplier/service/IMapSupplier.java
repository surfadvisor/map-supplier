package com.surf.advisor.map.supplier.service;

import com.surf.advisor.map.supplier.domain.MapQuery;
import com.surf.advisor.map.supplier.web.api.model.MapSupplierResponse;

public interface IMapSupplier {

    MapSupplierResponse queryRectangle(MapQuery query);

    MapSupplierResponse queryCircle(MapQuery query);
}
