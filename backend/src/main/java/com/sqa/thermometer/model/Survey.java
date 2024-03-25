package com.sqa.thermometer.model;

import com.sqa.thermometer.dto.SurveyDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID surveyId;

    @ManyToOne
    @JoinColumn(name = "teamId")//Crea un atributo en la entidad Survey de la BD con este nombre
    private Team team;

   /* @ManyToMany(mappedBy = "surveyList")
    private List<Question> questionList;*/

   public Survey(SurveyDTO surveyDTO){
        this.surveyId = surveyDTO.getSurveyId();
        this.team.setTeamId( surveyDTO.getTeamId());
  }
}
