package com.sqa.thermometer.model;

import com.sqa.thermometer.dto.SurveyDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Survey {

    @Id
    @JdbcTypeCode(SqlTypes.CHAR)
    @UuidGenerator
    private UUID surveyId;

    @ManyToOne
    @JoinColumn(name = "teamId")//Crea un atributo en la entidad Survey de la BD con este nombre
    private Team team;

   /* @ManyToMany(mappedBy = "surveyList")
    private List<Question> questionList;*/

    public Survey(SurveyDTO surveyDTO) {

        //TeamService teamService = new TeamService();

        this.surveyId = surveyDTO.getSurveyId();
        //this.team = new Team(surveyDTO.getTeamDTO());
        this.team.setTeamId(surveyDTO.getTeamId());
        //this.team = surveyDTO.;
        // this.team = new Team(teamService.findById(surveyDTO.getTeamId()));
    }
}
