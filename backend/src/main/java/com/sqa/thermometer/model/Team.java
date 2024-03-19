package com.sqa.thermometer.model;

import com.sqa.thermometer.dto.TeamDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teamId;

    private String teamName;

    //@OneToMany( mappedBy = "team", cascade = CascadeType.ALL)
    //private List<Survey> surveyList;


    public Team(TeamDTO teamDTO) {
        this.teamId = teamDTO.getTeamId();
        this.teamName = teamDTO.getTeamName();

    }
}
