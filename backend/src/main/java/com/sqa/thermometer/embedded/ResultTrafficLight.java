package com.sqa.thermometer.embedded;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ResultTrafficLight implements Serializable {


    private String color;
    private Integer count;
    // private int green;
    // private int organge;
    // private int red;
    

    
}