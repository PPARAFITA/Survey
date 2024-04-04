package com.sqa.thermometer.domain.team.application;

import com.sqa.thermometer.domain.team.model.Team;
import com.sqa.thermometer.domain.team.model.TeamRepository;
import com.sqa.thermometer.infrastructure.team.rest.TeamDTO;
import org.springframework.stereotype.Service;

@Service
public class CreateTeamUseCase {

    private final TeamRepository teamRepository;

    public CreateTeamUseCase(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }


    public void create(TeamDTO teamDTO) {
        Team team = Team.create(teamDTO.teamId(), teamDTO.teamName());
        teamRepository.save(team);
    }
}
