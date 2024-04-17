package com.sqa.thermometer.dto;

import java.util.List;

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
    private List<ResultTrafficLight> responseList = null;


    public ResultMonthDTO(String questionId, String question,String questionType, List<ResultTrafficLight> resultList){
        this.question = question;
        this.questionId = questionId;
        this.questionType = questionType;
        
        //this.response = new ResultTrafficLight();
        this.responseList = resultList;

    }
}
