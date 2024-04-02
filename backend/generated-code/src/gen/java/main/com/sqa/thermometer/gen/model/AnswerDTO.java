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
 * AnswerDTO
 */

@JsonTypeName("Answer")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-02T09:26:03.226880+02:00[Europe/Madrid]", comments = "Generator version: 7.4.0")
public class AnswerDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private UUID answerId;

  private UUID surveyId;

  private UUID questionId;

  public AnswerDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AnswerDTO(UUID answerId, UUID surveyId, UUID questionId) {
    this.answerId = answerId;
    this.surveyId = surveyId;
    this.questionId = questionId;
  }

  public AnswerDTO answerId(UUID answerId) {
    this.answerId = answerId;
    return this;
  }

  /**
   * Get answerId
   * @return answerId
  */
  @NotNull @Valid 
  @Schema(name = "answerId", example = "47455c16-41ee-4622-8a75-697aacfa2466", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("answerId")
  public UUID getAnswerId() {
    return answerId;
  }

  public void setAnswerId(UUID answerId) {
    this.answerId = answerId;
  }

  public AnswerDTO surveyId(UUID surveyId) {
    this.surveyId = surveyId;
    return this;
  }

  /**
   * Get surveyId
   * @return surveyId
  */
  @NotNull @Valid 
  @Schema(name = "surveyId", example = "47455c16-41ee-4622-8a75-697aacfa2466", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("surveyId")
  public UUID getSurveyId() {
    return surveyId;
  }

  public void setSurveyId(UUID surveyId) {
    this.surveyId = surveyId;
  }

  public AnswerDTO questionId(UUID questionId) {
    this.questionId = questionId;
    return this;
  }

  /**
   * Get questionId
   * @return questionId
  */
  @NotNull @Valid 
  @Schema(name = "questionId", example = "47455c16-41ee-4622-8a75-697aacfa2466", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("questionId")
  public UUID getQuestionId() {
    return questionId;
  }

  public void setQuestionId(UUID questionId) {
    this.questionId = questionId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnswerDTO answer = (AnswerDTO) o;
    return Objects.equals(this.answerId, answer.answerId) &&
        Objects.equals(this.surveyId, answer.surveyId) &&
        Objects.equals(this.questionId, answer.questionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(answerId, surveyId, questionId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AnswerDTO {\n");
    sb.append("    answerId: ").append(toIndentedString(answerId)).append("\n");
    sb.append("    surveyId: ").append(toIndentedString(surveyId)).append("\n");
    sb.append("    questionId: ").append(toIndentedString(questionId)).append("\n");
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

