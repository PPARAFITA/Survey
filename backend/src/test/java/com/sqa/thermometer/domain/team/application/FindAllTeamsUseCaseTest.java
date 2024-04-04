package com.sqa.thermometer.domain.team.application;

import com.sqa.thermometer.domain.team.model.Team;
import com.sqa.thermometer.domain.team.model.TeamMother;
import com.sqa.thermometer.domain.team.model.TeamRepository;
import com.sqa.thermometer.infrastructure.team.rest.TeamDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class FindAllTeamsUseCaseTest {

    private FindAllTeamsUseCase useCase;

    @Mock
    private TeamRepository teamRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        useCase = new FindAllTeamsUseCase(teamRepository);
    }

    @Test
    void whenEmptyListReturnThenReturnEmpty() {
        //given
        when(teamRepository.findAll()).thenReturn(List.of());
        //then
        List<TeamDTO> result = useCase.find();
        //when
        assertTrue(result.isEmpty());
    }

    @Test
    void whenListFillReturnThenReturnFilled() {
        //given
        Team team1 = TeamMother.random();
        Team team2 = TeamMother.random();
        when(teamRepository.findAll()).thenReturn(List.of(team1, team2));
        //then
        List<TeamDTO> result = useCase.find();
        //when
        assertEquals(2, result.size());
        assertEquals(team1.getId(), result.get(0).teamId());
        assertEquals(team1.getName(), result.get(0).teamName());
        assertEquals(team2.getId(), result.get(1).teamId());
        assertEquals(team2.getName(), result.get(1).teamName());
    }
}