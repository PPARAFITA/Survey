package com.sqa.thermometer.dto;

import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.sqa.thermometer.model.OptionQuestion;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OptionDTO {
        @JdbcTypeCode(SqlTypes.CHAR)
        private UUID optionId;
        @JdbcTypeCode(SqlTypes.CHAR)
        private UUID surveyId;
        @JdbcTypeCode(SqlTypes.CHAR)
        private UUID questionId;
        private String valorOption;
        private String color;

        public OptionDTO(OptionQuestion option){
            this.optionId = option.getOptionId();
            this.questionId = option.getQuestion().getQuestionId();
            this.surveyId = option.getSurvey().getSurveyId();
            this.valorOption = option.getValorOption();
            this.color = option.getColor();
        }
    }


