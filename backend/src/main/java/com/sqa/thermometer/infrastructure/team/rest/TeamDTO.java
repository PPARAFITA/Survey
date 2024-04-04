package com.sqa.thermometer.infrastructure.team.rest;


import com.sqa.thermometer.domain.team.model.Team;
import java.util.UUID;

public record TeamDTO(UUID teamId, String teamName) {

    public static TeamDTO fromTeam(Team team) {
        return new TeamDTO(team.getId(), team.getName());
    }
}
