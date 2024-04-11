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
    
    private String color;
    private Integer count;
    private Integer month;

     public ResultKPIDTO(String color, Integer count, Integer month) {
        this.color = color;
        this.count = count;
        this.month = month;
     }
}
