package com.sqa.thermometer.dto;

import com.sqa.thermometer.model.Team;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class TeamDTO {
    private UUID teamId;
    private String teamName;
   // private List<SurveyDTO> surveyDTOList;


    public TeamDTO(Team team){
        this.teamId = team.getTeamId();
        this.teamName = team.getTeamName();

      /*  if(team.getSurveyList() != null){
        this.surveyDTOList = new ArrayList<>();

        team.getSurveyList().forEach(
                survey -> this.surveyDTOList.add(new SurveyDTO(survey))
        );*/
    }

}
