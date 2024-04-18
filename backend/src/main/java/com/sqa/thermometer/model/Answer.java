package com.sqa.thermometer.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import com.sqa.thermometer.dto.AnswerDTO;
import com.sqa.thermometer.embedded.AnswerId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @JoinColumn(name = "survey_id", insertable = false, updatable = false)
    private Survey survey;

    @ManyToOne
    @MapsId( "questionId")
    @JoinColumn(name = "question_id", insertable = false, updatable = false)
    private Question question;

    @ManyToOne
    @JoinColumn(name = "option_id") 
    private OptionQuestion option;

    //@NotNull(message = "the field valorAnswer cannot be null")
    //@NotBlank(message = "the field valorAnswer cannot be blank")
    private String valorAnswer;

    @CreationTimestamp
    private LocalDateTime creationDate;

    

    public Answer(AnswerDTO answerDTO){

        this.answerId  = new AnswerId();        
        this.answerId.setId(answerDTO.getAnswerId());
        this.answerId.setSurveyId(answerDTO.getSurveyId());
        this.answerId.setQuestionId(answerDTO.getQuestionId());
        
        this.question = new Question();
        this.question.setQuestionId(answerDTO.getQuestionId());
        
        this.survey = new Survey();
        this.survey.setSurveyId(answerDTO.getSurveyId());
        
        if( answerDTO.getOptionId() != null){
            this.option = new OptionQuestion();
            this.option.setOptionId(answerDTO.getOptionId());
        }
        this.valorAnswer = answerDTO.getValorAnswer();

    }
}
