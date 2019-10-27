package com.surf.advisor.map.supplier.domain;

import com.surf.advisor.map.supplier.web.api.model.ObjectStatus;
import com.surf.advisor.map.supplier.web.api.model.ObjectType;
import com.surf.advisor.map.supplier.web.api.model.Rectangle;
import java.util.Set;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RectangleMapQuery {

    private Rectangle rectangle;

    private Set<ObjectType> objectTypes;
    private ObjectStatus status;

    private String country;
    private String state;
    private String city;

}
