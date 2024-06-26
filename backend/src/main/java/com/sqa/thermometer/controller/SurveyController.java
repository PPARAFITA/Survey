package com.sqa.thermometer.controller;

import com.sqa.thermometer.dto.SurveyDTO;
import com.sqa.thermometer.service.SurveyService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/thermometer/survey")
public class SurveyController {
    @Autowired
    private SurveyService surveyService;
    @PostMapping("/save")
    public ResponseEntity<SurveyDTO> save(@Valid @RequestBody SurveyDTO surveyDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(surveyDTO, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(surveyService.save(surveyDTO), HttpStatus.CREATED);
        }
        
    }

    @GetMapping
    public ResponseEntity<List<SurveyDTO>> findAll(){
        return new ResponseEntity<>(surveyService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SurveyDTO> findById(UUID id) {
        try {
            return new ResponseEntity<>(surveyService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
