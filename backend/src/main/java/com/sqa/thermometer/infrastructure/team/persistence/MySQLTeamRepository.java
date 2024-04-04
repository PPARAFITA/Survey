package com.sqa.thermometer.infrastructure.team.persistence;

import com.sqa.thermometer.domain.team.model.Team;
import com.sqa.thermometer.domain.team.model.TeamNotFoundException;
import com.sqa.thermometer.domain.team.model.TeamRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class MySQLTeamRepository implements TeamRepository {

    private final TeamRepositoryJPA teamRepositoryJpa;

    public MySQLTeamRepository(TeamRepositoryJPA teamRepositoryJpa) {
        this.teamRepositoryJpa = teamRepositoryJpa;
    }

    @Override
    public void save(Team team) {
        TeamEntity teamEntity = new TeamEntity(team.getId(), team.getName());
        teamRepositoryJpa.save(teamEntity);
    }

    @Override
    public Team find(UUID id) {
        TeamEntity entity = teamRepositoryJpa.findById(id).orElseThrow(() -> new TeamNotFoundException(id));
        return new Team(entity.getTeamId(), entity.getTeamName());
    }

    @Override
    public List<Team> findAll() {
        List<TeamEntity> teams = teamRepositoryJpa.findAll();
        return teams.stream().map(entity -> new Team(entity.getTeamId(), entity.getTeamName())).toList();
    }

    @Override
    public void delete(UUID id) {
        teamRepositoryJpa.deleteById(id);
    }
}
