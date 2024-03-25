package com.sqa.thermometer.model;

import com.sqa.thermometer.embedded.OptionId;
import com.sqa.thermometer.dto.OptionDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class OptionQuestion {

    @EmbeddedId
    private OptionId optionId;

    @ManyToOne
    @MapsId( "surveyId")
    @JoinColumn(name = "survey_id")
    private Survey survey;

    @ManyToOne
    @MapsId( "questionId")
    @JoinColumn(name = "question_id")
    private Question question;

    private String valorOption;

    private String color;

    public OptionQuestion(OptionDTO optionDTO){
        this.optionId = new OptionId();

        this.optionId.setOptionId(optionDTO.getOptionId());
        this.optionId.setSurveyId(optionDTO.getSurveyId());
        this.optionId.setQuestionId(optionDTO.getQuestionId());
        this.valorOption = optionDTO.getValorOption();
        this.color = optionDTO.getColor();

    }
}
