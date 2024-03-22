package com.sqa.thermometer.dto;

import com.sqa.thermometer.model.OptionQuestion;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OptionDTO {
        private Integer optionId;
        private Integer surveyId;
        private Integer questionId;
        private String valorOption;
        private String color;

        public OptionDTO(OptionQuestion option){
            this.optionId = option.getOptionId().getOptionId();
            this.questionId = option.getQuestion().getQuestionId();
            this.surveyId = option.getSurvey().getSurveyId();
            this.valorOption = option.getValorOption();
            this.color = option.getColor();
        }
    }


