package com.sqa.thermometer.infrastructure.team.persistence;

import com.sqa.thermometer.domain.team.model.Team;
import com.sqa.thermometer.domain.team.model.TeamMother;
import com.sqa.thermometer.domain.team.model.TeamNotFoundException;
import com.sqa.thermometer.domain.team.model.TeamRepository;
import com.sqa.thermometer.shared.TestContainerBase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

@Import({MySQLTeamRepository.class})
@DataJpaTest(includeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE))
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TeamRepositoryTest extends TestContainerBase {

    @Autowired
    private TeamRepository repository;

    @Autowired
    private TeamRepositoryJPA repositoryJpa;

    @AfterEach
    void tearDown() {
        repositoryJpa.deleteAll();
    }

    @Test
    void testSaveTeam() {
        //Given
        Team team = TeamMother.random();
        //when
        repository.save(team);
        //then
        Team savedTeam = repository.find(team.getId());

        Assertions.assertEquals(team, savedTeam);
    }

    @Test
    void testFind() {
        //given
        TeamEntity teamEntity = TeamEntityMother.random();
        repositoryJpa.save(teamEntity);

        //when
        Team team = repository.find(teamEntity.getTeamId());
        //then
        Assertions.assertEquals(teamEntity.getTeamId(), team.getId());
        Assertions.assertEquals(teamEntity.getTeamName(), team.getName());
    }

    @Test
    void testFindNotExists() {
        UUID id = UUID.randomUUID();
        TeamNotFoundException thrown = assertThrows(TeamNotFoundException.class, () -> repository.find(id));
        Assertions.assertTrue(thrown.getMessage().contains(id.toString()));
    }

    @Test
    void testFindAllEmpty(){
        //when
        List<Team> all = repository.findAll();
        //then
        Assertions.assertTrue(all.isEmpty());
    }

    @Test
    void testFindAllMultiple(){
        //given
        TeamEntity teamEntity1 = TeamEntityMother.random();
        TeamEntity teamEntity2 = TeamEntityMother.random();
        repositoryJpa.save(teamEntity1);
        repositoryJpa.save(teamEntity2);
        //when
        List<Team> all = repository.findAll();
        //then
        Assertions.assertEquals(2, all.size());
    }

    @Test
    void testDelete(){
        //given
        TeamEntity teamEntity1 = TeamEntityMother.random();
        repositoryJpa.save(teamEntity1);
        //when
        repository.delete(teamEntity1.getTeamId());
        //then
        List<Team> all = repository.findAll();
        Assertions.assertTrue(all.isEmpty());
    }
}