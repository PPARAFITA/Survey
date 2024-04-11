package com.sqa.thermometer.dto;

import com.sqa.thermometer.embedded.ResultTrafficLight;
import com.sqa.thermometer.model.Survey;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ResultMonthDTO {
    
        
    private String questionId;
    private String question;
    private String questionType;
    private Object response = null;


    public ResultMonthDTO(String questionId, String question,String questionType){
        this.question = question;
        this.questionId = questionId;
        this.questionType = questionType;

    }
}
