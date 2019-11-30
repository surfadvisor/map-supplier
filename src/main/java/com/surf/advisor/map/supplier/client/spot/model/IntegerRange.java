package com.surf.advisor.map.supplier.client.spot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * IntegerRange
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-11-29T18:51:13.606+01:00[Europe/Belgrade]")

public class IntegerRange implements Serializable {
  @JsonProperty("from")
  private Integer from;

  @JsonProperty("to")
  private Integer to;

  public IntegerRange from(Integer from) {
    this.from = from;
    return this;
  }

  /**
   * inclusive start number
   * @return from
  */
  @ApiModelProperty(value = "inclusive start number")


  public Integer getFrom() {
    return from;
  }

  public void setFrom(Integer from) {
    this.from = from;
  }

  public IntegerRange to(Integer to) {
    this.to = to;
    return this;
  }

  /**
   * inclusive end number
   * @return to
  */
  @ApiModelProperty(value = "inclusive end number")


  public Integer getTo() {
    return to;
  }

  public void setTo(Integer to) {
    this.to = to;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IntegerRange integerRange = (IntegerRange) o;
    return Objects.equals(this.from, integerRange.from) &&
        Objects.equals(this.to, integerRange.to);
  }

  @Override
  public int hashCode() {
    return Objects.hash(from, to);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IntegerRange {\n");

    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

