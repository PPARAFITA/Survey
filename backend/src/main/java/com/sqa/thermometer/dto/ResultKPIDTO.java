package com.sqa.thermometer.dto;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.sqa.thermometer.embedded.ResultTrafficLight;
import com.sqa.thermometer.model.Survey;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultKPIDTO {
    
    private String questionId;
    private String questionType;
    private String month;
    private ResultTrafficLight response = null;

     public ResultKPIDTO(String questionId, String month, ResultTrafficLight response ) {
         this.questionId = questionId;
         //this.questionType = questionType;
         this.month = month;
         this.response = response;
     }
}
