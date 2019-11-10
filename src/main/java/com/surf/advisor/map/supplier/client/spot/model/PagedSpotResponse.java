package com.surf.advisor.map.supplier.client.spot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;

/**
 * PagedSpotResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-10-30T23:19:38.378218400+01:00[Europe/Belgrade]")

public class PagedSpotResponse implements Serializable {
  @JsonProperty("spots")
  @Valid
  private List<Spot> spots = null;

  @JsonProperty("lastKey")
  private String lastKey;

  @JsonProperty("limit")
  private Integer limit;

  @JsonProperty("size")
  private Integer size;

  public PagedSpotResponse spots(List<Spot> spots) {
    this.spots = spots;
    return this;
  }

  public PagedSpotResponse addSpotsItem(Spot spotsItem) {
    if (this.spots == null) {
      this.spots = new ArrayList<Spot>();
    }
    this.spots.add(spotsItem);
    return this;
  }

  /**
   * Get spots
   * @return spots
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<Spot> getSpots() {
    return spots;
  }

  public void setSpots(List<Spot> spots) {
    this.spots = spots;
  }

  public PagedSpotResponse lastKey(String lastKey) {
    this.lastKey = lastKey;
    return this;
  }

  /**
   * last evaluated key received from previous dynamoDB query
   * @return lastKey
  */
  @ApiModelProperty(value = "last evaluated key received from previous dynamoDB query")


  public String getLastKey() {
    return lastKey;
  }

  public void setLastKey(String lastKey) {
    this.lastKey = lastKey;
  }

  public PagedSpotResponse limit(Integer limit) {
    this.limit = limit;
    return this;
  }

  /**
   * queried page size
   * @return limit
  */
  @ApiModelProperty(value = "queried page size")


  public Integer getLimit() {
    return limit;
  }

  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  public PagedSpotResponse size(Integer size) {
    this.size = size;
    return this;
  }

  /**
   * items count
   * @return size
  */
  @ApiModelProperty(value = "items count")


  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PagedSpotResponse pagedSpotResponse = (PagedSpotResponse) o;
    return Objects.equals(this.spots, pagedSpotResponse.spots) &&
        Objects.equals(this.lastKey, pagedSpotResponse.lastKey) &&
        Objects.equals(this.limit, pagedSpotResponse.limit) &&
        Objects.equals(this.size, pagedSpotResponse.size);
  }

  @Override
  public int hashCode() {
    return Objects.hash(spots, lastKey, limit, size);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PagedSpotResponse {\n");
    
    sb.append("    spots: ").append(toIndentedString(spots)).append("\n");
    sb.append("    lastKey: ").append(toIndentedString(lastKey)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
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

