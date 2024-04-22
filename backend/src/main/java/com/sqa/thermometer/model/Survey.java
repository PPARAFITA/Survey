package com.sqa.thermometer.model;

import com.sqa.thermometer.dto.SurveyDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.CHAR)
    @UuidGenerator
    private UUID surveyId;

    /*Relacion entre la entidad Survey y team */
    @ManyToOne
    @JoinColumn(name = "team_id")//Crea un atributo en la entidad Survey de la BD con este nombre
    private Team team;

    /*Relacion entre la entidad Survey y optionQuestion */
    @OneToMany(mappedBy = "survey")
    private List<OptionQuestion> optionList;

    /*Relacion entre la entidad Survey y Question */
    @OneToMany(mappedBy = "survey")
    private List<Question>  questionList;

   public Survey(SurveyDTO surveyDTO){
        
        this.surveyId = surveyDTO.getSurveyId();
       
        this.team = new Team();
        this.team.setTeamId(surveyDTO.getTeamId());
        
       
        
  }
}
