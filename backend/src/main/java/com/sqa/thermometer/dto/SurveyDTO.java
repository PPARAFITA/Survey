package com.sqa.thermometer.dto;

import com.sqa.thermometer.model.Survey;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@NoArgsConstructor
public class SurveyDTO {
    private UUID surveyId;
    private UUID teamId;
   // private List<QuestionDTO> questionDTOList;


    public SurveyDTO(Survey survey){
        this.surveyId = survey.getSurveyId();
        this.teamId = survey.getTeam().getTeamId();
      /*  this.questionDTOList = new ArrayList<>();
        survey.getQuestionList().forEach(
                question -> {
                    this.questionDTOList.add(new QuestionDTO(question));
                }
        );*/


    }
}
