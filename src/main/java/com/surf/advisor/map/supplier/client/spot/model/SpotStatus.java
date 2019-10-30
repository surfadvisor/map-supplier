package com.surf.advisor.map.supplier.client.spot.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets SpotStatus
 */
public enum SpotStatus {
  
  DRAFT("DRAFT"),
  
  DECLINED("DECLINED"),
  
  AVAILABLE("AVAILABLE");

  private String value;

  SpotStatus(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static SpotStatus fromValue(String value) {
    for (SpotStatus b : SpotStatus.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

