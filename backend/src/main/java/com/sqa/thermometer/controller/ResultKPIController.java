package com.sqa.thermometer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sqa.thermometer.service.AnswerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/api/v1/thermometer/resultKPI")
public class ResultKPIController {
   
    @Autowired
    private AnswerService answerService;

    @GetMapping("/{question}")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    

}
