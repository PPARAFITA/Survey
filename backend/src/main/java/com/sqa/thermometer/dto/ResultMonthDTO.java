package com.sqa.thermometer.dto;

import com.sqa.thermometer.embedded.ResultTrafficLight;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ResultMonthDTO {
    
        
    private String questionId;
    private String question;
    private String questionType;
    private Integer qtyAnswers;
    private ResultTrafficLight response = null;


    public ResultMonthDTO(String questionId, String question,String questionType, Integer qtyAnswers, ResultTrafficLight resultList){
        this.question = question;
        this.questionId = questionId;
        this.questionType = questionType;
        this.qtyAnswers = qtyAnswers;
        this.response = resultList;

    }
}
