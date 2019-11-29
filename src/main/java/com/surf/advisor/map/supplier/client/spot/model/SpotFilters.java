package com.surf.advisor.map.supplier.client.spot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * SpotFilters
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-11-29T18:51:13.606+01:00[Europe/Belgrade]")

public class SpotFilters   {
  @JsonProperty("ids")
  @Valid
  private List<String> ids = null;

  @JsonProperty("status")
  @Valid
  private List<SpotStatus> status = null;

  @JsonProperty("country")
  @Valid
  private List<CountryCode> country = null;

  @JsonProperty("state")
  private String state;

  @JsonProperty("city")
  private String city;

  @JsonProperty("name")
  private String name;

  @JsonProperty("facilities")
  @Valid
  private List<SpotFacility> facilities = null;

  @JsonProperty("difficulty")
  @Valid
  private List<Difficulty> difficulty = null;

  @JsonProperty("depth")
  @Valid
  private List<Depth> depth = null;

  @JsonProperty("sportTypes")
  @Valid
  private List<SportType> sportTypes = null;

  @JsonProperty("waterType")
  @Valid
  private List<WaterType> waterType = null;

  @JsonProperty("waveAvgPeriod")
  private IntegerRange waveAvgPeriod = null;

  @JsonProperty("waveAvgSize")
  private IntegerRange waveAvgSize = null;

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

  public SpotFilters status(List<SpotStatus> status) {
    this.status = status;
    return this;
  }

  public SpotFilters addStatusItem(SpotStatus statusItem) {
    if (this.status == null) {
      this.status = new ArrayList<SpotStatus>();
    }
    this.status.add(statusItem);
    return this;
  }

  /**
   * status values
   * @return status
  */
  @ApiModelProperty(value = "status values")

  @Valid

  public List<SpotStatus> getStatus() {
    return status;
  }

  public void setStatus(List<SpotStatus> status) {
    this.status = status;
  }

  public SpotFilters country(List<CountryCode> country) {
    this.country = country;
    return this;
  }

  public SpotFilters addCountryItem(CountryCode countryItem) {
    if (this.country == null) {
      this.country = new ArrayList<CountryCode>();
    }
    this.country.add(countryItem);
    return this;
  }

  /**
   * Get country
   * @return country
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<CountryCode> getCountry() {
    return country;
  }

  public void setCountry(List<CountryCode> country) {
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

  public SpotFilters facilities(List<SpotFacility> facilities) {
    this.facilities = facilities;
    return this;
  }

  public SpotFilters addFacilitiesItem(SpotFacility facilitiesItem) {
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

  public SpotFilters difficulty(List<Difficulty> difficulty) {
    this.difficulty = difficulty;
    return this;
  }

  public SpotFilters addDifficultyItem(Difficulty difficultyItem) {
    if (this.difficulty == null) {
      this.difficulty = new ArrayList<Difficulty>();
    }
    this.difficulty.add(difficultyItem);
    return this;
  }

  /**
   * Get difficulty
   * @return difficulty
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<Difficulty> getDifficulty() {
    return difficulty;
  }

  public void setDifficulty(List<Difficulty> difficulty) {
    this.difficulty = difficulty;
  }

  public SpotFilters depth(List<Depth> depth) {
    this.depth = depth;
    return this;
  }

  public SpotFilters addDepthItem(Depth depthItem) {
    if (this.depth == null) {
      this.depth = new ArrayList<Depth>();
    }
    this.depth.add(depthItem);
    return this;
  }

  /**
   * Get depth
   * @return depth
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<Depth> getDepth() {
    return depth;
  }

  public void setDepth(List<Depth> depth) {
    this.depth = depth;
  }

  public SpotFilters sportTypes(List<SportType> sportTypes) {
    this.sportTypes = sportTypes;
    return this;
  }

  public SpotFilters addSportTypesItem(SportType sportTypesItem) {
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

  public SpotFilters waterType(List<WaterType> waterType) {
    this.waterType = waterType;
    return this;
  }

  public SpotFilters addWaterTypeItem(WaterType waterTypeItem) {
    if (this.waterType == null) {
      this.waterType = new ArrayList<WaterType>();
    }
    this.waterType.add(waterTypeItem);
    return this;
  }

  /**
   * Get waterType
   * @return waterType
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<WaterType> getWaterType() {
    return waterType;
  }

  public void setWaterType(List<WaterType> waterType) {
    this.waterType = waterType;
  }

  public SpotFilters waveAvgPeriod(IntegerRange waveAvgPeriod) {
    this.waveAvgPeriod = waveAvgPeriod;
    return this;
  }

  /**
   * Get waveAvgPeriod
   * @return waveAvgPeriod
  */
  @ApiModelProperty(value = "")

  @Valid

  public IntegerRange getWaveAvgPeriod() {
    return waveAvgPeriod;
  }

  public void setWaveAvgPeriod(IntegerRange waveAvgPeriod) {
    this.waveAvgPeriod = waveAvgPeriod;
  }

  public SpotFilters waveAvgSize(IntegerRange waveAvgSize) {
    this.waveAvgSize = waveAvgSize;
    return this;
  }

  /**
   * Get waveAvgSize
   * @return waveAvgSize
  */
  @ApiModelProperty(value = "")

  @Valid

  public IntegerRange getWaveAvgSize() {
    return waveAvgSize;
  }

  public void setWaveAvgSize(IntegerRange waveAvgSize) {
    this.waveAvgSize = waveAvgSize;
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
        Objects.equals(this.name, spotFilters.name) &&
        Objects.equals(this.facilities, spotFilters.facilities) &&
        Objects.equals(this.difficulty, spotFilters.difficulty) &&
        Objects.equals(this.depth, spotFilters.depth) &&
        Objects.equals(this.sportTypes, spotFilters.sportTypes) &&
        Objects.equals(this.waterType, spotFilters.waterType) &&
        Objects.equals(this.waveAvgPeriod, spotFilters.waveAvgPeriod) &&
        Objects.equals(this.waveAvgSize, spotFilters.waveAvgSize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ids, status, country, state, city, name, facilities, difficulty, depth, sportTypes, waterType, waveAvgPeriod, waveAvgSize);
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
    sb.append("    facilities: ").append(toIndentedString(facilities)).append("\n");
    sb.append("    difficulty: ").append(toIndentedString(difficulty)).append("\n");
    sb.append("    depth: ").append(toIndentedString(depth)).append("\n");
    sb.append("    sportTypes: ").append(toIndentedString(sportTypes)).append("\n");
    sb.append("    waterType: ").append(toIndentedString(waterType)).append("\n");
    sb.append("    waveAvgPeriod: ").append(toIndentedString(waveAvgPeriod)).append("\n");
    sb.append("    waveAvgSize: ").append(toIndentedString(waveAvgSize)).append("\n");
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

