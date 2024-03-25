package com.sqa.thermometer.dto;

import com.sqa.thermometer.model.Answer;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

import java.util.UUID;

@Data
@NoArgsConstructor
public class AnswerDTO {
    private UUID answerId;
    private UUID surveyId;
    private UUID questionId;
    private String valorAnswer;

    public AnswerDTO(Answer answer){
        this.answerId = answer.getAnswerId().getAnswerId();
        this.questionId = answer.getQuestion().getQuestionId();
        this.surveyId = answer.getSurvey().getSurveyId();
        this.valorAnswer = answer.getValorAnswer();
    }
}
