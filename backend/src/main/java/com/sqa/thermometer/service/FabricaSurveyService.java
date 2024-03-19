package com.sqa.thermometer.service;

import com.sqa.thermometer.dto.SurveyDTO;
import com.sqa.thermometer.model.Survey;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FabricaSurveyService {

    public Survey createSurvey(SurveyDTO surveyDTO){
        return new Survey(surveyDTO);
    }

    public SurveyDTO createSurveyDTO(Survey survey){
        return new SurveyDTO(survey);
    }

    public List<SurveyDTO> createSurveysDTO(List<Survey> surveyList) {

        List<SurveyDTO> surveyDTOList = new ArrayList<>();

        surveyList.stream().forEach(
                survey -> {
                    surveyDTOList.add(new SurveyDTO(survey));
                }
        );
        return surveyDTOList;
    }
}
