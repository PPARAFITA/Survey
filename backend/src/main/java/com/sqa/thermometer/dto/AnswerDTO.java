package com.sqa.thermometer.dto;

import com.sqa.thermometer.model.Answer;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.objenesis.instantiator.android.AndroidSerializationInstantiator;

@Data
@NoArgsConstructor
public class AnswerDTO {
    private Integer answerId;
    private Integer surveyId;
    private Integer questionId;
    private String valorAnswer;

    public AnswerDTO(Answer answer){
        this.answerId = answer.getAnswerId().getAnswerId();
        this.questionId = answer.getQuestion().getQuestionId();
        this.surveyId = answer.getSurvey().getSurveyId();
        this.valorAnswer = answer.getValorAnswer();
    }
}
