package com.sqa.thermometer.dto;

import com.sqa.thermometer.model.Question;
import com.sqa.thermometer.model.Survey;
import com.sqa.thermometer.model.Team;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class SurveyDTO {
    private Integer surveyId;
    //private TeamDTO teamDTO;
    private Integer teamId;
   // private List<QuestionDTO> questionDTOList;


    public SurveyDTO(Survey survey){
        this.surveyId = survey.getSurveyId();
       // this.teamId = survey.getTeam().getTeamId();
        this.teamId = survey.getTeam().getTeamId();
      /*  this.questionDTOList = new ArrayList<>();
        survey.getQuestionList().forEach(
                question -> {
                    this.questionDTOList.add(new QuestionDTO(question));
                }
        );*/


    }
}
