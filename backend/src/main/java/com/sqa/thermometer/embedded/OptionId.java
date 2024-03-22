package com.sqa.thermometer.embedded;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import java.io.Serializable;

@Data
@Embeddable
public class OptionId implements Serializable {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id")
    private Integer optionId;

    @Column(name = "survey_id")
    private Integer surveyId;

    @Column(name = "question_id")
    private Integer questionId;
}


