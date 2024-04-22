package com.sqa.thermometer.embedded;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ResultTrafficLight implements Serializable {

    private Long orange;
    private Long red;
    private Long green;
    
    public ResultTrafficLight(Long redCount, Long greenCount, Long orangeCount){
        this.red = redCount;
        this.green = greenCount;
        this.orange = orangeCount;
    }  
}