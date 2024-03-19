package com.sqa.thermometer.model;

import com.sqa.thermometer.dto.SurveyDTO;
import com.sqa.thermometer.service.TeamService;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer surveyId;

    @ManyToOne
    @JoinColumn(name = "teamId")//Crea un atributo en la entidad Survey de la BD con este nombre
    private Team team;

   /* @ManyToMany(mappedBy = "surveyList")
    private List<Question> questionList;*/

   public Survey(SurveyDTO surveyDTO){

        //TeamService teamService = new TeamService();

        this.surveyId = surveyDTO.getSurveyId();
        //this.team = new Team(surveyDTO.getTeamDTO());
        this.team.setTeamId( surveyDTO.getTeamId());
        //this.team = surveyDTO.;
       // this.team = new Team(teamService.findById(surveyDTO.getTeamId()));
  }
}
