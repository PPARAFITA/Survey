package com.sqa.thermometer.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sqa.thermometer.dto.ResultKPIDTO;
import com.sqa.thermometer.dto.ResultMonthDTO;
import com.sqa.thermometer.dto.TeamDTO;
import com.sqa.thermometer.service.AnswerService;

@RestController
@RequestMapping("/api/v1/thermometer/resultMonth")
public class ResultMonthController {

    @Autowired
    private AnswerService answerService;

    @GetMapping("/{month}/{questionId}")
    public ResponseEntity<List<ResultKPIDTO>> getResultByMonth(@PathVariable String month, @PathVariable String questionId){
        return new ResponseEntity<>(answerService.findByIdAndMonth( questionId, month),HttpStatus.OK);
    }

    @GetMapping("/{team}/{month}")
    public ResponseEntity<List<ResultKPIDTO>> getResultByMonths(@PathVariable String month, @PathVariable String questionId){
        return new ResponseEntity<>(answerService.findByIdAndMonth( questionId, month),HttpStatus.OK);
    }    
}