package com.sqa.thermometer.embedded;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import java.io.Serializable;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;

@Data
@Embeddable
public class OptionId implements Serializable {
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.CHAR)
    @UuidGenerator
    @Column(name = "option_id")
    private UUID optionId;

    @JdbcTypeCode(SqlTypes.CHAR)
    @UuidGenerator
    @Column(name = "survey_id")
    private UUID surveyId;

    @JdbcTypeCode(SqlTypes.CHAR)
    @UuidGenerator
    @Column(name = "question_id")
    private UUID questionId;
}


