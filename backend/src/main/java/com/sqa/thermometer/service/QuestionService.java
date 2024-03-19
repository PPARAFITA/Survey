package com.sqa.thermometer.service;

import com.sqa.thermometer.dto.QuestionDTO;
import com.sqa.thermometer.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private FabricaQuestionService fabricaQuestionService;


    public QuestionDTO save(QuestionDTO questionDTO){
        return fabricaQuestionService.createQuestionDTO(questionRepository.save(fabricaQuestionService.createQuestion(questionDTO)));
    }
    public List<QuestionDTO> findAll(){
        return fabricaQuestionService.createQuestionsDTO(questionRepository.findAll());
    }

    public QuestionDTO findById(Integer id){
        return fabricaQuestionService.createQuestionDTO(questionRepository.findById(id).get());
    }
}
