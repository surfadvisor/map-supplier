package com.surf.advisor.map.supplier.client.spot.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets WaterCurrent
 */
public enum WaterCurrent {

  N("N"),

  S("S"),

  M("M"),

  H("H");

  private String value;

  WaterCurrent(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static WaterCurrent fromValue(String value) {
    for (WaterCurrent b : WaterCurrent.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

