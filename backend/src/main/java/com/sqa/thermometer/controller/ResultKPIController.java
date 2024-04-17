package com.sqa.thermometer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sqa.thermometer.dto.ResultKPIDTO;
import com.sqa.thermometer.dto.ResultMonthDTO;
import com.sqa.thermometer.service.AnswerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/api/v1/thermometer/resultKPI")
public class ResultKPIController {
   
    @Autowired
    private AnswerService answerService;

    @GetMapping
    public ResponseEntity<List<ResultKPIDTO>> getResultsByQuestion(@RequestParam("questionId") String questionId, @RequestParam("teamId") String teamId) {
        return new ResponseEntity<>(answerService.findByTeamAndQuestion(teamId, questionId), HttpStatus.OK);
    }
      
}
