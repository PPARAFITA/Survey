package com.sqa.thermometer.controller;

import com.sqa.thermometer.dto.QuestionDTO;
import com.sqa.thermometer.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/thermometer/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

  /*  @PostMapping("/save")
    public ResponseEntity<QuestionDTO> save(@RequestBody QuestionDTO questionDTO){
        return new ResponseEntity<>(questionService.save(questionDTO), HttpStatus.CREATED);
    }

    @PostMapping("/saveAll")
    public ResponseEntity<List<QuestionDTO>> save(@RequestBody List<QuestionDTO> questionDTOList){

        List<QuestionDTO> questionDTOListaCreada = new ArrayList<>();

        questionDTOList.forEach(
                questionDTO -> {
                    questionDTOListaCreada.add(questionService.save(questionDTO));
                }
        );
        return new ResponseEntity<>(questionDTOListaCreada, HttpStatus.CREATED);
    }*/

    @GetMapping
    public ResponseEntity<List<QuestionDTO>> findAll(){
        return new ResponseEntity<>(questionService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{teamId}")
    public ResponseEntity<List<QuestionDTO>> findAll(@PathVariable String teamId ){
        return new ResponseEntity<>(questionService.findQuestionsByTeam(teamId),HttpStatus.OK);
    }

  /*  @GetMapping("/{id}")
    public ResponseEntity<QuestionDTO> findById(@PathVariable Integer id){
        return new ResponseEntity<>(questionService.findById(id),HttpStatus.OK);
    }*/
}
