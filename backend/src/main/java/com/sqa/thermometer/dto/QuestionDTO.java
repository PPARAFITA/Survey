package com.sqa.thermometer.dto;

import com.sqa.thermometer.model.Question;
import com.sqa.thermometer.model.Survey;
import com.sqa.thermometer.repository.QuestionRepository;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuestionDTO {
    private Integer questionId;
    private String question;
    private String questionType;

    public QuestionDTO(Question question){
        this.questionId = question.getQuestionId();
        this.question = question.getQuestion();
        this.questionType = question.getQuestionType();
    }

}
