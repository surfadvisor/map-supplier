package com.surf.advisor.map.supplier.client.spot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;

/**
 * spot identifiers
 */
@ApiModel(description = "spot identifiers")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-10-25T23:03:35.113761100+02:00[Europe/Belgrade]")

public class SpotIdListResponse   {
  @JsonProperty("ids")
  @Valid
  private List<String> ids = null;

  public SpotIdListResponse ids(List<String> ids) {
    this.ids = ids;
    return this;
  }

  public SpotIdListResponse addIdsItem(String idsItem) {
    if (this.ids == null) {
      this.ids = new ArrayList<String>();
    }
    this.ids.add(idsItem);
    return this;
  }

  /**
   * Get ids
   * @return ids
  */
  @ApiModelProperty(value = "")


  public List<String> getIds() {
    return ids;
  }

  public void setIds(List<String> ids) {
    this.ids = ids;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpotIdListResponse spotIdListResponse = (SpotIdListResponse) o;
    return Objects.equals(this.ids, spotIdListResponse.ids);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ids);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpotIdListResponse {\n");
    
    sb.append("    ids: ").append(toIndentedString(ids)).append("\n");
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

