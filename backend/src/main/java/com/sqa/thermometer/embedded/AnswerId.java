package com.sqa.thermometer.embedded;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Embeddable
@Data
public class AnswerId implements Serializable {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private Integer answerId;

    @Column(name = "survey_id")
    private Integer surveyId;

    @Column(name = "question_id")
    private Integer questionId;
}
