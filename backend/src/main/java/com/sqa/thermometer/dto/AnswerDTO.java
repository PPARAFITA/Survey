package com.sqa.thermometer.dto;
 
import com.sqa.thermometer.model.Answer;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.util.UUID;
 
@Data
@NoArgsConstructor
public class AnswerDTO {
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID answerId;
  
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID surveyId;
  
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID questionId;
    
<<<<<<< HEAD
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID teamId;    
 
=======
    // @JdbcTypeCode(SqlTypes.CHAR)
    // private UUID teamId;    

>>>>>>> f27d39f (Fix error in AnswerDTO)
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID optionId;
   
    private String valorAnswer;
 
    public AnswerDTO(Answer answer){
        this.answerId = answer.getAnswerId().getId();
        this.questionId = answer.getQuestion().getQuestionId();
        this.surveyId = answer.getSurvey().getSurveyId();
<<<<<<< HEAD
        if(answer.getOption() != null){
            this.setOptionId(answer.getOption().getOptionId());
        }
 
        this.valorAnswer = answer.getValorAnswer();
       
=======
        this.valorAnswer = answer.getValorAnswer();

        if(answer.getOption() != null){
            this.setOptionId(answer.getOption().getOptionId());
        }
>>>>>>> f27d39f (Fix error in AnswerDTO)
    }
}