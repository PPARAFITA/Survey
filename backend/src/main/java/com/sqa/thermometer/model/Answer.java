package com.sqa.thermometer.model;

import com.sqa.thermometer.dto.AnswerDTO;
import com.sqa.thermometer.embedded.AnswerId;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Answer {

    @EmbeddedId
    private AnswerId answerId;

    @ManyToOne
    @MapsId( "surveyId")
    @JoinColumn(name = "survey_id")
    private Survey survey;

    @ManyToOne
    @MapsId( "questionId")
    @JoinColumn(name = "question_id")
    private Question question;

    private String valorAnswer;

    public Answer(AnswerDTO answerDTO){

       // this.answerId.setAnswerId(answerDTO.getAnswerId());
        this.answerId  = new AnswerId();
        this.answerId.setAnswerId(answerDTO.getAnswerId());
        this.answerId.setSurveyId(answerDTO.getSurveyId());
        this.answerId.setQuestionId(answerDTO.getQuestionId());
        this.valorAnswer = answerDTO.getValorAnswer();

    }
}
