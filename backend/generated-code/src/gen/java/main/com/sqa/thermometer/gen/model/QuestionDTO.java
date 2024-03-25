package com.sqa.thermometer.gen.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
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
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-24T18:53:38.194613+01:00[Europe/Madrid]", comments = "Generator version: 7.4.0")
public class QuestionDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private UUID id;

  private String question;

  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    TRAFFIC_LIGHT("traffic_light");

    private String value;

    TypeEnum(String value) {
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
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private TypeEnum type;

  public QuestionDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public QuestionDTO(UUID id, String question, TypeEnum type) {
    this.id = id;
    this.question = question;
    this.type = type;
  }

  public QuestionDTO id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @NotNull @Valid 
  @Schema(name = "id", example = "47455c16-41ee-4622-8a75-697aacfa2466", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
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

  public QuestionDTO type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */
  @NotNull 
  @Schema(name = "type", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("type")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
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
    return Objects.equals(this.id, question.id) &&
        Objects.equals(this.question, question.question) &&
        Objects.equals(this.type, question.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, question, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QuestionDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    question: ").append(toIndentedString(question)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

