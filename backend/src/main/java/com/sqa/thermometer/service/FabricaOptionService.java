package com.sqa.thermometer.service;

import org.springframework.stereotype.Service;

import com.sqa.thermometer.dto.OptionDTO;
import com.sqa.thermometer.dto.QuestionDTO;
import com.sqa.thermometer.model.OptionQuestion;
import com.sqa.thermometer.model.Question;

@Service
public class FabricaOptionService {
     public OptionQuestion createQuestion(OptionDTO optionDTO){
        return new OptionQuestion(optionDTO);
    }
}
