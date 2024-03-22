package com.sqa.thermometer.model;

import com.sqa.thermometer.dto.TeamDTO;
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
public class Team {
    @Id
    @Column(name = "id")
    @JdbcTypeCode(SqlTypes.CHAR)
    @UuidGenerator
    private UUID teamId;

    @Column(name = "name")
    private String teamName;

    //@OneToMany( mappedBy = "team", cascade = CascadeType.ALL)
    //private List<Survey> surveyList;


    public Team(TeamDTO teamDTO) {
        this.teamId = teamDTO.getTeamId();
        this.teamName = teamDTO.getTeamName();

    }
}
