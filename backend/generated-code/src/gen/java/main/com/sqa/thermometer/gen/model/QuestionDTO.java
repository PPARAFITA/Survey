package com.sqa.thermometer.gen.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.sqa.thermometer.gen.model.ArrayOptionquestionDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
 * QuestionDTO
 */

@JsonTypeName("Question")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-02T09:26:03.226880+02:00[Europe/Madrid]", comments = "Generator version: 7.4.0")
public class QuestionDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Optional<UUID> optionId = Optional.empty();

  private UUID questionId;

  /**
   * Gets or Sets questionType
   */
  public enum QuestionTypeEnum {
    TRAFFIC_LIGHT("traffic_light");

    private String value;

    QuestionTypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static QuestionTypeEnum fromValue(String value) {
      for (QuestionTypeEnum b : QuestionTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private QuestionTypeEnum questionType;

  private String question;

  @Valid
  private List<@Valid ArrayOptionquestionDTO> optionDTOList = new ArrayList<>();

  public QuestionDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public QuestionDTO(UUID questionId, QuestionTypeEnum questionType, String question, List<@Valid ArrayOptionquestionDTO> optionDTOList) {
    this.questionId = questionId;
    this.questionType = questionType;
    this.question = question;
    this.optionDTOList = optionDTOList;
  }

  public QuestionDTO optionId(UUID optionId) {
    this.optionId = Optional.of(optionId);
    return this;
  }

  /**
   * Get optionId
   * @return optionId
  */
  @Valid 
  @Schema(name = "optionId", example = "47455c16-41ee-4622-8a75-697aacfa2466", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("optionId")
  public Optional<UUID> getOptionId() {
    return optionId;
  }

  public void setOptionId(Optional<UUID> optionId) {
    this.optionId = optionId;
  }

  public QuestionDTO questionId(UUID questionId) {
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

  public QuestionDTO questionType(QuestionTypeEnum questionType) {
    this.questionType = questionType;
    return this;
  }

  /**
   * Get questionType
   * @return questionType
  */
  @NotNull 
  @Schema(name = "questionType", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("questionType")
  public QuestionTypeEnum getQuestionType() {
    return questionType;
  }

  public void setQuestionType(QuestionTypeEnum questionType) {
    this.questionType = questionType;
  }

  public QuestionDTO question(String question) {
    this.question = question;
    return this;
  }

  /**
   * Get question
   * @return question
  */
  @NotNull 
  @Schema(name = "question", example = "How are you feeling today?", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("question")
  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public QuestionDTO optionDTOList(List<@Valid ArrayOptionquestionDTO> optionDTOList) {
    this.optionDTOList = optionDTOList;
    return this;
  }

  public QuestionDTO addOptionDTOListItem(ArrayOptionquestionDTO optionDTOListItem) {
    if (this.optionDTOList == null) {
      this.optionDTOList = new ArrayList<>();
    }
    this.optionDTOList.add(optionDTOListItem);
    return this;
  }

  /**
   * Get optionDTOList
   * @return optionDTOList
  */
  @NotNull @Valid 
  @Schema(name = "optionDTOList", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("optionDTOList")
  public List<@Valid ArrayOptionquestionDTO> getOptionDTOList() {
    return optionDTOList;
  }

  public void setOptionDTOList(List<@Valid ArrayOptionquestionDTO> optionDTOList) {
    this.optionDTOList = optionDTOList;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QuestionDTO question = (QuestionDTO) o;
    return Objects.equals(this.optionId, question.optionId) &&
        Objects.equals(this.questionId, question.questionId) &&
        Objects.equals(this.questionType, question.questionType) &&
        Objects.equals(this.question, question.question) &&
        Objects.equals(this.optionDTOList, question.optionDTOList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(optionId, questionId, questionType, question, optionDTOList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QuestionDTO {\n");
    sb.append("    optionId: ").append(toIndentedString(optionId)).append("\n");
    sb.append("    questionId: ").append(toIndentedString(questionId)).append("\n");
    sb.append("    questionType: ").append(toIndentedString(questionType)).append("\n");
    sb.append("    question: ").append(toIndentedString(question)).append("\n");
    sb.append("    optionDTOList: ").append(toIndentedString(optionDTOList)).append("\n");
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

