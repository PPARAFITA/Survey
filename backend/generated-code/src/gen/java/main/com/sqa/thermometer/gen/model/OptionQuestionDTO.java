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
 * OptionQuestionDTO
 */

@JsonTypeName("Option_question")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-24T18:53:38.194613+01:00[Europe/Madrid]", comments = "Generator version: 7.4.0")
public class OptionQuestionDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private UUID optionId;

  private UUID questionId;

  private UUID surveyId;

  private String color;

  private String valorOption;

  public OptionQuestionDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public OptionQuestionDTO(UUID optionId, UUID questionId, UUID surveyId, String color, String valorOption) {
    this.optionId = optionId;
    this.questionId = questionId;
    this.surveyId = surveyId;
    this.color = color;
    this.valorOption = valorOption;
  }

  public OptionQuestionDTO optionId(UUID optionId) {
    this.optionId = optionId;
    return this;
  }

  /**
   * Get optionId
   * @return optionId
  */
  @NotNull @Valid 
  @Schema(name = "optionId", example = "47455c16-41ee-4622-8a75-697aacfa2466", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("optionId")
  public UUID getOptionId() {
    return optionId;
  }

  public void setOptionId(UUID optionId) {
    this.optionId = optionId;
  }

  public OptionQuestionDTO questionId(UUID questionId) {
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

  public OptionQuestionDTO surveyId(UUID surveyId) {
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

  public OptionQuestionDTO color(String color) {
    this.color = color;
    return this;
  }

  /**
   * Get color
   * @return color
  */
  @NotNull 
  @Schema(name = "color", example = "green", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("color")
  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public OptionQuestionDTO valorOption(String valorOption) {
    this.valorOption = valorOption;
    return this;
  }

  /**
   * Get valorOption
   * @return valorOption
  */
  @NotNull 
  @Schema(name = "valor_option", example = "good", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("valor_option")
  public String getValorOption() {
    return valorOption;
  }

  public void setValorOption(String valorOption) {
    this.valorOption = valorOption;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OptionQuestionDTO optionQuestion = (OptionQuestionDTO) o;
    return Objects.equals(this.optionId, optionQuestion.optionId) &&
        Objects.equals(this.questionId, optionQuestion.questionId) &&
        Objects.equals(this.surveyId, optionQuestion.surveyId) &&
        Objects.equals(this.color, optionQuestion.color) &&
        Objects.equals(this.valorOption, optionQuestion.valorOption);
  }

  @Override
  public int hashCode() {
    return Objects.hash(optionId, questionId, surveyId, color, valorOption);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OptionQuestionDTO {\n");
    sb.append("    optionId: ").append(toIndentedString(optionId)).append("\n");
    sb.append("    questionId: ").append(toIndentedString(questionId)).append("\n");
    sb.append("    surveyId: ").append(toIndentedString(surveyId)).append("\n");
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
    sb.append("    valorOption: ").append(toIndentedString(valorOption)).append("\n");
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

