package com.sqa.thermometer.model;

import com.sqa.thermometer.dto.QuestionDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Question {
    @Id
    @JdbcTypeCode(SqlTypes.CHAR)
    @UuidGenerator
    private UUID questionId;
    private String questionType;
    private String question;

   /* @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable( name = "question_survey", joinColumns = @JoinColumn(name = "questionId", referencedColumnName = "questionId"),
    inverseJoinColumns = @JoinColumn(name = "surveyId",referencedColumnName = "surveyId")
    )
    private List<Survey> surveyList;*/

    public Question(QuestionDTO questionDTO){
        this.questionId = questionDTO.getQuestionId();
        this.questionType = questionDTO.getQuestionType();
        this.question = questionDTO.getQuestion();
    }
}
