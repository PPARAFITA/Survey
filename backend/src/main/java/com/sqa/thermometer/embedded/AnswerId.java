package com.sqa.thermometer.embedded;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Data
public class AnswerId implements Serializable {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID answerId;

    @Column(name = "survey_id")
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID surveyId;

    @Column(name = "question_id")
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID questionId;
}
