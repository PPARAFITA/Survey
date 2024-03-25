package com.sqa.thermometer.model;

import com.sqa.thermometer.dto.QuestionDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
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
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.CHAR)
    @UuidGenerator
    private UUID questionId;
    private String questionType;
    private String question;
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OptionQuestion> optionQuestion;

   /* @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable( name = "question_survey", joinColumns = @JoinColumn(name = "questionId", referencedColumnName = "questionId"),
    inverseJoinColumns = @JoinColumn(name = "surveyId",referencedColumnName = "surveyId")
    )
    private List<Survey> surveyList;*/

    public Question(QuestionDTO questionDTO){
        this.questionId = questionDTO.getQuestionId();
        this.questionType = questionDTO.getQuestionType();
        this.question = questionDTO.getQuestion();
        this.optionQuestion = new ArrayList<>();
      
        questionDTO.getOptionDTOList().forEach(option ->{

            this.optionQuestion.add(new OptionQuestion(option));
        });;
    }
}
