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
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-25T17:24:37.245512+01:00[Europe/Madrid]", comments = "Generator version: 7.4.0")
public class AnswerDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private UUID questionId;

  private Optional<String> answers = Optional.empty();

  public AnswerDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AnswerDTO(UUID questionId) {
    this.questionId = questionId;
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

  public AnswerDTO answers(String answers) {
    this.answers = Optional.of(answers);
    return this;
  }

  /**
   * Get answers
   * @return answers
  */
  
  @Schema(name = "answers", example = "green", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("answers")
  public Optional<String> getAnswers() {
    return answers;
  }

  public void setAnswers(Optional<String> answers) {
    this.answers = answers;
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
    return Objects.equals(this.questionId, answer.questionId) &&
        Objects.equals(this.answers, answer.answers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(questionId, answers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AnswerDTO {\n");
    sb.append("    questionId: ").append(toIndentedString(questionId)).append("\n");
    sb.append("    answers: ").append(toIndentedString(answers)).append("\n");
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

