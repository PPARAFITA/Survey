package com.sqa.thermometer.dto;

import com.sqa.thermometer.embedded.ResultTrafficLight;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultKPIDTO {
    
    private String questionId;
    private String questionType;
    private String month;
    private Integer qtyAnswers;
    private ResultTrafficLight response = null;

     public ResultKPIDTO(String questionId, String questionType , String month, Integer qtyAnswers, ResultTrafficLight response ) {
         this.questionId = questionId;
         this.questionType = questionType;
         this.month = month;
         this.qtyAnswers = qtyAnswers;
         this.response = response;
     }
}
