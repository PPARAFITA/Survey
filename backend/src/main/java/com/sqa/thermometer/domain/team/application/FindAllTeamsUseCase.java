package com.sqa.thermometer.domain.team.application;

import com.sqa.thermometer.domain.team.model.Team;
import com.sqa.thermometer.domain.team.model.TeamRepository;
import com.sqa.thermometer.infrastructure.team.rest.TeamDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllTeamsUseCase {

    private final TeamRepository teamRepository;

    public FindAllTeamsUseCase(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<TeamDTO> find(){
        List<Team> teams = teamRepository.findAll();
        return teams.stream().map(TeamDTO::fromTeam).toList();
    }

}
