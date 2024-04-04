package com.sqa.thermometer.model;

import com.sqa.thermometer.dto.SurveyDTO;
import com.sqa.thermometer.infrastructure.team.persistence.TeamEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;
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

    @ManyToOne
    @JoinColumn(name = "teamId")//Crea un atributo en la entidad Survey de la BD con este nombre
    private TeamEntity teamEntity;

   /* @ManyToMany(mappedBy = "surveyList")
    private List<Question> questionList;*/

   public Survey(SurveyDTO surveyDTO){
        this.surveyId = surveyDTO.getSurveyId();
        this.teamEntity.setTeamId( surveyDTO.getTeamId());
  }
}
