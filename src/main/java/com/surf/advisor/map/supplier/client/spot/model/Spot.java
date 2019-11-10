package com.surf.advisor.map.supplier.client.spot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Spot
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-10-30T23:19:38.378218400+01:00[Europe/Belgrade]")

public class Spot implements Serializable {
  @JsonProperty("id")
  private String id;

  @JsonProperty("country")
  private String country;

  @JsonProperty("state")
  private String state;

  @JsonProperty("city")
  private String city;

  @JsonProperty("name")
  private String name;

  @JsonProperty("photoUrls")
  @Valid
  private List<String> photoUrls = null;

  @JsonProperty("status")
  private SpotStatus status = SpotStatus.AVAILABLE;

  public Spot id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(value = "")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Spot country(String country) {
    this.country = country;
    return this;
  }

  /**
   * Get country
   * @return country
  */
  @ApiModelProperty(example = "PL", required = true, value = "")
  @NotNull


  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Spot state(String state) {
    this.state = state;
    return this;
  }

  /**
   * Get state
   * @return state
  */
  @ApiModelProperty(example = "pomorskie", required = true, value = "")
  @NotNull


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Spot city(String city) {
    this.city = city;
    return this;
  }

  /**
   * Get city
   * @return city
  */
  @ApiModelProperty(example = "Hel", required = true, value = "")
  @NotNull


  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Spot name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(example = "Hel Molo", required = true, value = "")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Spot photoUrls(List<String> photoUrls) {
    this.photoUrls = photoUrls;
    return this;
  }

  public Spot addPhotoUrlsItem(String photoUrlsItem) {
    if (this.photoUrls == null) {
      this.photoUrls = new ArrayList<String>();
    }
    this.photoUrls.add(photoUrlsItem);
    return this;
  }

  /**
   * Get photoUrls
   * @return photoUrls
  */
  @ApiModelProperty(value = "")


  public List<String> getPhotoUrls() {
    return photoUrls;
  }

  public void setPhotoUrls(List<String> photoUrls) {
    this.photoUrls = photoUrls;
  }

  public Spot status(SpotStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @ApiModelProperty(value = "")

  @Valid

  public SpotStatus getStatus() {
    return status;
  }

  public void setStatus(SpotStatus status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Spot spot = (Spot) o;
    return Objects.equals(this.id, spot.id) &&
        Objects.equals(this.country, spot.country) &&
        Objects.equals(this.state, spot.state) &&
        Objects.equals(this.city, spot.city) &&
        Objects.equals(this.name, spot.name) &&
        Objects.equals(this.photoUrls, spot.photoUrls) &&
        Objects.equals(this.status, spot.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, country, state, city, name, photoUrls, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Spot {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    photoUrls: ").append(toIndentedString(photoUrls)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

