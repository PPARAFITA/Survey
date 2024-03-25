package com.sqa.thermometer.gen.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * SurveyDTO
 */

@JsonTypeName("Survey")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-24T18:53:38.194613+01:00[Europe/Madrid]", comments = "Generator version: 7.4.0")
public class SurveyDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private UUID surveyId;

  private UUID teamId;

  public SurveyDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SurveyDTO(UUID surveyId, UUID teamId) {
    this.surveyId = surveyId;
    this.teamId = teamId;
  }

  public SurveyDTO surveyId(UUID surveyId) {
    this.surveyId = surveyId;
    return this;
  }

  /**
   * Get surveyId
   * @return surveyId
  */
  @NotNull @Valid 
  @Schema(name = "surveyId", example = "b2f7a764-14b5-45dd-9222-0a4a746f4f7d", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("surveyId")
  public UUID getSurveyId() {
    return surveyId;
  }

  public void setSurveyId(UUID surveyId) {
    this.surveyId = surveyId;
  }

  public SurveyDTO teamId(UUID teamId) {
    this.teamId = teamId;
    return this;
  }

  /**
   * Get teamId
   * @return teamId
  */
  @NotNull @Valid 
  @Schema(name = "teamId", example = "b2f7a764-14b5-45dd-9222-0a4a746f4f7d", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("teamId")
  public UUID getTeamId() {
    return teamId;
  }

  public void setTeamId(UUID teamId) {
    this.teamId = teamId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SurveyDTO survey = (SurveyDTO) o;
    return Objects.equals(this.surveyId, survey.surveyId) &&
        Objects.equals(this.teamId, survey.teamId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(surveyId, teamId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SurveyDTO {\n");
    sb.append("    surveyId: ").append(toIndentedString(surveyId)).append("\n");
    sb.append("    teamId: ").append(toIndentedString(teamId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

