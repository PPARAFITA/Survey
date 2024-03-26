package com.sqa.thermometer.embedded;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import java.io.Serializable;
import java.util.UUID;

@Data
@Embeddable
public class OptionId implements Serializable {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "option_id")
    private UUID optionId;

    @Column(name = "survey_id")
    private UUID surveyId;

    @Column(name = "question_id")
    private UUID questionId;
}


