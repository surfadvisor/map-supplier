package com.surf.advisor.map.supplier.client.spot.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;

/**
 * SpotFilters
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-10-25T23:03:35.113761100+02:00[Europe/Belgrade]")

public class SpotFilters   {
  @JsonProperty("ids")
  @Valid
  private List<String> ids = null;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    DRAFT("DRAFT"),
    
    DECLINED("DECLINED"),
    
    AVAILABLE("AVAILABLE");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("status")
  @Valid
  private List<StatusEnum> status = null;

  @JsonProperty("country")
  private String country;

  @JsonProperty("state")
  private String state;

  @JsonProperty("city")
  private String city;

  @JsonProperty("name")
  private String name;

  public SpotFilters ids(List<String> ids) {
    this.ids = ids;
    return this;
  }

  public SpotFilters addIdsItem(String idsItem) {
    if (this.ids == null) {
      this.ids = new ArrayList<String>();
    }
    this.ids.add(idsItem);
    return this;
  }

  /**
   * spot identifiers
   * @return ids
  */
  @ApiModelProperty(value = "spot identifiers")


  public List<String> getIds() {
    return ids;
  }

  public void setIds(List<String> ids) {
    this.ids = ids;
  }

  public SpotFilters status(List<StatusEnum> status) {
    this.status = status;
    return this;
  }

  public SpotFilters addStatusItem(StatusEnum statusItem) {
    if (this.status == null) {
      this.status = new ArrayList<StatusEnum>();
    }
    this.status.add(statusItem);
    return this;
  }

  /**
   * status values
   * @return status
  */
  @ApiModelProperty(value = "status values")


  public List<StatusEnum> getStatus() {
    return status;
  }

  public void setStatus(List<StatusEnum> status) {
    this.status = status;
  }

  public SpotFilters country(String country) {
    this.country = country;
    return this;
  }

  /**
   * Get country
   * @return country
  */
  @ApiModelProperty(example = "PL", value = "")


  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public SpotFilters state(String state) {
    this.state = state;
    return this;
  }

  /**
   * Get state
   * @return state
  */
  @ApiModelProperty(example = "pomorskie", value = "")


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public SpotFilters city(String city) {
    this.city = city;
    return this;
  }

  /**
   * Get city
   * @return city
  */
  @ApiModelProperty(example = "Hel", value = "")


  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public SpotFilters name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(example = "Hel Molo", value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpotFilters spotFilters = (SpotFilters) o;
    return Objects.equals(this.ids, spotFilters.ids) &&
        Objects.equals(this.status, spotFilters.status) &&
        Objects.equals(this.country, spotFilters.country) &&
        Objects.equals(this.state, spotFilters.state) &&
        Objects.equals(this.city, spotFilters.city) &&
        Objects.equals(this.name, spotFilters.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ids, status, country, state, city, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpotFilters {\n");
    
    sb.append("    ids: ").append(toIndentedString(ids)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

