package com.sqa.thermometer.service;

import com.sqa.thermometer.dto.SurveyDTO;
import com.sqa.thermometer.model.Survey;
import com.sqa.thermometer.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyService {
    @Autowired
    private SurveyRepository surveyRepository;
    @Autowired
    private FabricaSurveyService fabricaSurveyService;

    public SurveyDTO save(SurveyDTO surveyDTO){
        return new SurveyDTO(fabricaSurveyService.createSurvey(surveyDTO));
    } public List<SurveyDTO> findAll(){
        return fabricaSurveyService.createSurveysDTO(surveyRepository.findAll());
    }

    public SurveyDTO findById(Integer id){
        return fabricaSurveyService.createSurveyDTO(surveyRepository.findById(id).get());
    }


}
