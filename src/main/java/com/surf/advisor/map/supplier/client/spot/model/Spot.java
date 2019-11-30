package com.surf.advisor.map.supplier.client.spot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Spot
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-11-29T18:51:13.606+01:00[Europe/Belgrade]")

public class Spot implements Serializable {
  @JsonProperty("id")
  private String id;

  @JsonProperty("country")
  private CountryCode country;

  @JsonProperty("state")
  private String state;

  @JsonProperty("city")
  private String city;

  @JsonProperty("name")
  private String name;

  @JsonProperty("descriptions")
  @Valid
  private List<Description> descriptions = null;

  @JsonProperty("photoUrls")
  @Valid
  private List<String> photoUrls = null;

  @JsonProperty("liveCamera")
  @Valid
  private List<String> liveCamera = null;

  @JsonProperty("status")
  private SpotStatus status;

  @JsonProperty("sportTypes")
  @Valid
  private List<SportType> sportTypes = null;

  @JsonProperty("waterType")
  private WaterType waterType;

  @JsonProperty("popularity")
  private Popularity popularity;

  @JsonProperty("facilities")
  @Valid
  private List<SpotFacility> facilities = null;

  @JsonProperty("difficulty")
  private Difficulty difficulty;

  @JsonProperty("depth")
  private Depth depth;

  @JsonProperty("dangers")
  private String dangers;

  @JsonProperty("bestWindDirections")
  @Valid
  private List<BasicWindDirection> bestWindDirections = null;

  @JsonProperty("worstWindDirections")
  @Valid
  private List<BasicWindDirection> worstWindDirections = null;

  @JsonProperty("chopSize")
  private ChopSize chopSize;

  @JsonProperty("waveQuality")
  private Integer waveQuality;

  @JsonProperty("waveAvgPeriod")
  private Integer waveAvgPeriod;

  @JsonProperty("waveAvgSize")
  private Integer waveAvgSize;

  @JsonProperty("waveMaxSize")
  private Integer waveMaxSize;

  @JsonProperty("waterCurrent")
  private WaterCurrent waterCurrent;

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

  public Spot country(CountryCode country) {
    this.country = country;
    return this;
  }

  /**
   * Get country
   * @return country
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public CountryCode getCountry() {
    return country;
  }

  public void setCountry(CountryCode country) {
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

  public Spot descriptions(List<Description> descriptions) {
    this.descriptions = descriptions;
    return this;
  }

  public Spot addDescriptionsItem(Description descriptionsItem) {
    if (this.descriptions == null) {
      this.descriptions = new ArrayList<Description>();
    }
    this.descriptions.add(descriptionsItem);
    return this;
  }

  /**
   * Get descriptions
   * @return descriptions
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<Description> getDescriptions() {
    return descriptions;
  }

  public void setDescriptions(List<Description> descriptions) {
    this.descriptions = descriptions;
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

  public Spot liveCamera(List<String> liveCamera) {
    this.liveCamera = liveCamera;
    return this;
  }

  public Spot addLiveCameraItem(String liveCameraItem) {
    if (this.liveCamera == null) {
      this.liveCamera = new ArrayList<String>();
    }
    this.liveCamera.add(liveCameraItem);
    return this;
  }

  /**
   * live camera urls
   * @return liveCamera
  */
  @ApiModelProperty(value = "live camera urls")


  public List<String> getLiveCamera() {
    return liveCamera;
  }

  public void setLiveCamera(List<String> liveCamera) {
    this.liveCamera = liveCamera;
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

  public Spot sportTypes(List<SportType> sportTypes) {
    this.sportTypes = sportTypes;
    return this;
  }

  public Spot addSportTypesItem(SportType sportTypesItem) {
    if (this.sportTypes == null) {
      this.sportTypes = new ArrayList<SportType>();
    }
    this.sportTypes.add(sportTypesItem);
    return this;
  }

  /**
   * Get sportTypes
   * @return sportTypes
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<SportType> getSportTypes() {
    return sportTypes;
  }

  public void setSportTypes(List<SportType> sportTypes) {
    this.sportTypes = sportTypes;
  }

  public Spot waterType(WaterType waterType) {
    this.waterType = waterType;
    return this;
  }

  /**
   * Get waterType
   * @return waterType
  */
  @ApiModelProperty(value = "")

  @Valid

  public WaterType getWaterType() {
    return waterType;
  }

  public void setWaterType(WaterType waterType) {
    this.waterType = waterType;
  }

  public Spot popularity(Popularity popularity) {
    this.popularity = popularity;
    return this;
  }

  /**
   * Get popularity
   * @return popularity
  */
  @ApiModelProperty(value = "")

  @Valid

  public Popularity getPopularity() {
    return popularity;
  }

  public void setPopularity(Popularity popularity) {
    this.popularity = popularity;
  }

  public Spot facilities(List<SpotFacility> facilities) {
    this.facilities = facilities;
    return this;
  }

  public Spot addFacilitiesItem(SpotFacility facilitiesItem) {
    if (this.facilities == null) {
      this.facilities = new ArrayList<SpotFacility>();
    }
    this.facilities.add(facilitiesItem);
    return this;
  }

  /**
   * Get facilities
   * @return facilities
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<SpotFacility> getFacilities() {
    return facilities;
  }

  public void setFacilities(List<SpotFacility> facilities) {
    this.facilities = facilities;
  }

  public Spot difficulty(Difficulty difficulty) {
    this.difficulty = difficulty;
    return this;
  }

  /**
   * Get difficulty
   * @return difficulty
  */
  @ApiModelProperty(value = "")

  @Valid

  public Difficulty getDifficulty() {
    return difficulty;
  }

  public void setDifficulty(Difficulty difficulty) {
    this.difficulty = difficulty;
  }

  public Spot depth(Depth depth) {
    this.depth = depth;
    return this;
  }

  /**
   * Get depth
   * @return depth
  */
  @ApiModelProperty(value = "")

  @Valid

  public Depth getDepth() {
    return depth;
  }

  public void setDepth(Depth depth) {
    this.depth = depth;
  }

  public Spot dangers(String dangers) {
    this.dangers = dangers;
    return this;
  }

  /**
   * free form string describing any potential risk
   * @return dangers
  */
  @ApiModelProperty(value = "free form string describing any potential risk")


  public String getDangers() {
    return dangers;
  }

  public void setDangers(String dangers) {
    this.dangers = dangers;
  }

  public Spot bestWindDirections(List<BasicWindDirection> bestWindDirections) {
    this.bestWindDirections = bestWindDirections;
    return this;
  }

  public Spot addBestWindDirectionsItem(BasicWindDirection bestWindDirectionsItem) {
    if (this.bestWindDirections == null) {
      this.bestWindDirections = new ArrayList<BasicWindDirection>();
    }
    this.bestWindDirections.add(bestWindDirectionsItem);
    return this;
  }

  /**
   * Get bestWindDirections
   * @return bestWindDirections
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<BasicWindDirection> getBestWindDirections() {
    return bestWindDirections;
  }

  public void setBestWindDirections(List<BasicWindDirection> bestWindDirections) {
    this.bestWindDirections = bestWindDirections;
  }

  public Spot worstWindDirections(List<BasicWindDirection> worstWindDirections) {
    this.worstWindDirections = worstWindDirections;
    return this;
  }

  public Spot addWorstWindDirectionsItem(BasicWindDirection worstWindDirectionsItem) {
    if (this.worstWindDirections == null) {
      this.worstWindDirections = new ArrayList<BasicWindDirection>();
    }
    this.worstWindDirections.add(worstWindDirectionsItem);
    return this;
  }

  /**
   * Get worstWindDirections
   * @return worstWindDirections
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<BasicWindDirection> getWorstWindDirections() {
    return worstWindDirections;
  }

  public void setWorstWindDirections(List<BasicWindDirection> worstWindDirections) {
    this.worstWindDirections = worstWindDirections;
  }

  public Spot chopSize(ChopSize chopSize) {
    this.chopSize = chopSize;
    return this;
  }

  /**
   * Get chopSize
   * @return chopSize
  */
  @ApiModelProperty(value = "")

  @Valid

  public ChopSize getChopSize() {
    return chopSize;
  }

  public void setChopSize(ChopSize chopSize) {
    this.chopSize = chopSize;
  }

  public Spot waveQuality(Integer waveQuality) {
    this.waveQuality = waveQuality;
    return this;
  }

  /**
   * overall subjective wave quality rating
   * minimum: 1
   * maximum: 10
   * @return waveQuality
  */
  @ApiModelProperty(value = "overall subjective wave quality rating")

@Min(1) @Max(10)
  public Integer getWaveQuality() {
    return waveQuality;
  }

  public void setWaveQuality(Integer waveQuality) {
    this.waveQuality = waveQuality;
  }

  public Spot waveAvgPeriod(Integer waveAvgPeriod) {
    this.waveAvgPeriod = waveAvgPeriod;
    return this;
  }

  /**
   * in seconds
   * minimum: 1
   * @return waveAvgPeriod
  */
  @ApiModelProperty(value = "in seconds")

@Min(1)
  public Integer getWaveAvgPeriod() {
    return waveAvgPeriod;
  }

  public void setWaveAvgPeriod(Integer waveAvgPeriod) {
    this.waveAvgPeriod = waveAvgPeriod;
  }

  public Spot waveAvgSize(Integer waveAvgSize) {
    this.waveAvgSize = waveAvgSize;
    return this;
  }

  /**
   * in meters
   * minimum: 0
   * @return waveAvgSize
  */
  @ApiModelProperty(value = "in meters")

@Min(0)
  public Integer getWaveAvgSize() {
    return waveAvgSize;
  }

  public void setWaveAvgSize(Integer waveAvgSize) {
    this.waveAvgSize = waveAvgSize;
  }

  public Spot waveMaxSize(Integer waveMaxSize) {
    this.waveMaxSize = waveMaxSize;
    return this;
  }

  /**
   * in meters
   * minimum: 0
   * @return waveMaxSize
  */
  @ApiModelProperty(value = "in meters")

@Min(0)
  public Integer getWaveMaxSize() {
    return waveMaxSize;
  }

  public void setWaveMaxSize(Integer waveMaxSize) {
    this.waveMaxSize = waveMaxSize;
  }

  public Spot waterCurrent(WaterCurrent waterCurrent) {
    this.waterCurrent = waterCurrent;
    return this;
  }

  /**
   * Get waterCurrent
   * @return waterCurrent
  */
  @ApiModelProperty(value = "")

  @Valid

  public WaterCurrent getWaterCurrent() {
    return waterCurrent;
  }

  public void setWaterCurrent(WaterCurrent waterCurrent) {
    this.waterCurrent = waterCurrent;
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
        Objects.equals(this.descriptions, spot.descriptions) &&
        Objects.equals(this.photoUrls, spot.photoUrls) &&
        Objects.equals(this.liveCamera, spot.liveCamera) &&
        Objects.equals(this.status, spot.status) &&
        Objects.equals(this.sportTypes, spot.sportTypes) &&
        Objects.equals(this.waterType, spot.waterType) &&
        Objects.equals(this.popularity, spot.popularity) &&
        Objects.equals(this.facilities, spot.facilities) &&
        Objects.equals(this.difficulty, spot.difficulty) &&
        Objects.equals(this.depth, spot.depth) &&
        Objects.equals(this.dangers, spot.dangers) &&
        Objects.equals(this.bestWindDirections, spot.bestWindDirections) &&
        Objects.equals(this.worstWindDirections, spot.worstWindDirections) &&
        Objects.equals(this.chopSize, spot.chopSize) &&
        Objects.equals(this.waveQuality, spot.waveQuality) &&
        Objects.equals(this.waveAvgPeriod, spot.waveAvgPeriod) &&
        Objects.equals(this.waveAvgSize, spot.waveAvgSize) &&
        Objects.equals(this.waveMaxSize, spot.waveMaxSize) &&
        Objects.equals(this.waterCurrent, spot.waterCurrent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, country, state, city, name, descriptions, photoUrls, liveCamera, status, sportTypes, waterType, popularity, facilities, difficulty, depth, dangers, bestWindDirections, worstWindDirections, chopSize, waveQuality, waveAvgPeriod, waveAvgSize, waveMaxSize, waterCurrent);
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
    sb.append("    descriptions: ").append(toIndentedString(descriptions)).append("\n");
    sb.append("    photoUrls: ").append(toIndentedString(photoUrls)).append("\n");
    sb.append("    liveCamera: ").append(toIndentedString(liveCamera)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    sportTypes: ").append(toIndentedString(sportTypes)).append("\n");
    sb.append("    waterType: ").append(toIndentedString(waterType)).append("\n");
    sb.append("    popularity: ").append(toIndentedString(popularity)).append("\n");
    sb.append("    facilities: ").append(toIndentedString(facilities)).append("\n");
    sb.append("    difficulty: ").append(toIndentedString(difficulty)).append("\n");
    sb.append("    depth: ").append(toIndentedString(depth)).append("\n");
    sb.append("    dangers: ").append(toIndentedString(dangers)).append("\n");
    sb.append("    bestWindDirections: ").append(toIndentedString(bestWindDirections)).append("\n");
    sb.append("    worstWindDirections: ").append(toIndentedString(worstWindDirections)).append("\n");
    sb.append("    chopSize: ").append(toIndentedString(chopSize)).append("\n");
    sb.append("    waveQuality: ").append(toIndentedString(waveQuality)).append("\n");
    sb.append("    waveAvgPeriod: ").append(toIndentedString(waveAvgPeriod)).append("\n");
    sb.append("    waveAvgSize: ").append(toIndentedString(waveAvgSize)).append("\n");
    sb.append("    waveMaxSize: ").append(toIndentedString(waveMaxSize)).append("\n");
    sb.append("    waterCurrent: ").append(toIndentedString(waterCurrent)).append("\n");
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

