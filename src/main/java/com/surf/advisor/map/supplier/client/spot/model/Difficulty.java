package com.surf.advisor.map.supplier.client.spot.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets Difficulty
 */
public enum Difficulty {

  EASY("EASY"),

  MEDIUM("MEDIUM"),

  HARD("HARD"),

  PROS_ONLY("PROS_ONLY");

  private String value;

  Difficulty(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static Difficulty fromValue(String value) {
    for (Difficulty b : Difficulty.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

