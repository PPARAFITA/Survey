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
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "answer_id")
    private UUID answerId;

    @Column(name = "survey_id")
    private UUID surveyId;

    @Column(name = "question_id")
    private UUID questionId;
}
