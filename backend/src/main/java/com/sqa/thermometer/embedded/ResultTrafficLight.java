package com.sqa.thermometer.embedded;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ResultTrafficLight implements Serializable {


    private String color;
    private Long count;
    // private int green;
    // private int organge;
    // private int red;
    
    public ResultTrafficLight(String color, Long count){
        this.color = color;
        this.count = count;
    }  
}