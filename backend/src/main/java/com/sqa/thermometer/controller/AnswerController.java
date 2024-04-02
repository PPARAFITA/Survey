package com.sqa.thermometer.controller;

import com.sqa.thermometer.dto.AnswerDTO;
import com.sqa.thermometer.service.AnswerService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/thermometer/answer")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @GetMapping
    public ResponseEntity<List<AnswerDTO>> findAll(){
        return new ResponseEntity<>(answerService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<List<AnswerDTO>> save(@Valid @RequestBody List<AnswerDTO> answerDTOList, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(answerDTOList,HttpStatus.BAD_REQUEST);
        }else{
          return new ResponseEntity<>(answerService.save(answerDTOList), HttpStatus.CREATED);
        }
    }
}
