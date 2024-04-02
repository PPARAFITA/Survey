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
 * TeamDTO
 */

@JsonTypeName("Team")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-02T09:26:03.226880+02:00[Europe/Madrid]", comments = "Generator version: 7.4.0")
public class TeamDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private UUID teamId;

  private String teamName;

  public TeamDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TeamDTO(UUID teamId, String teamName) {
    this.teamId = teamId;
    this.teamName = teamName;
  }

  public TeamDTO teamId(UUID teamId) {
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

  public TeamDTO teamName(String teamName) {
    this.teamName = teamName;
    return this;
  }

  /**
   * Get teamName
   * @return teamName
  */
  @NotNull 
  @Schema(name = "teamName", example = "SQA", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("teamName")
  public String getTeamName() {
    return teamName;
  }

  public void setTeamName(String teamName) {
    this.teamName = teamName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TeamDTO team = (TeamDTO) o;
    return Objects.equals(this.teamId, team.teamId) &&
        Objects.equals(this.teamName, team.teamName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(teamId, teamName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TeamDTO {\n");
    sb.append("    teamId: ").append(toIndentedString(teamId)).append("\n");
    sb.append("    teamName: ").append(toIndentedString(teamName)).append("\n");
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

