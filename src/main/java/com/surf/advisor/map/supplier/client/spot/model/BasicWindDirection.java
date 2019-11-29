package com.surf.advisor.map.supplier.client.spot.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets BasicWindDirection
 */
public enum BasicWindDirection {

  N("N"),

  NE("NE"),

  E("E"),

  SE("SE"),

  S("S"),

  SW("SW"),

  W("W"),

  NW("NW");

  private String value;

  BasicWindDirection(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static BasicWindDirection fromValue(String value) {
    for (BasicWindDirection b : BasicWindDirection.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

