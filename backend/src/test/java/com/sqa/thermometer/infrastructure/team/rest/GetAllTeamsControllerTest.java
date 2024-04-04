package com.sqa.thermometer.infrastructure.team.rest;

import com.sqa.thermometer.domain.team.application.FindAllTeamsUseCase;
import com.sqa.thermometer.shared.MvcTestBase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Import({GetAllTeamsControllerTest.TestConfig.class})
@WebMvcTest(value = GetAllTeamsController.class)
class GetAllTeamsControllerTest extends MvcTestBase {

    @Autowired
    private FindAllTeamsUseCase useCase;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    void whenEmptyReturnOKAndEmpty() throws Exception {
        //given
        when(useCase.find()).thenReturn(List.of());
        //when
        ResultActions result = mockMvc.perform(get("/api/v1/thermometer/team")
                        .contentType(MediaType.APPLICATION_JSON));

        //then
        result.andExpect(status().isOk());
        result.andExpect(content().contentType(MediaType.APPLICATION_JSON));
        result.andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    @WithMockUser
    void whenTwoTeamsReturnOKAndTheTeams() throws Exception {
        //given
        TeamDTO team1 = TeamDTOMother.random();
        TeamDTO team2 = TeamDTOMother.random();
        when(useCase.find()).thenReturn(List.of(team1, team2));
        //then
        ResultActions result = mockMvc.perform(get("/api/v1/thermometer/team")
                .contentType(MediaType.APPLICATION_JSON));

        //then
        result.andExpect(status().isOk());
        result.andExpect(content().contentType(MediaType.APPLICATION_JSON));
        result.andExpect(jsonPath("$", hasSize(2)));
        result.andExpect(jsonPath("$[0].teamId", is(team1.teamId().toString())));
        result.andExpect(jsonPath("$[0].teamName", is(team1.teamName())));
        result.andExpect(jsonPath("$[1].teamId", is(team2.teamId().toString())));
        result.andExpect(jsonPath("$[1].teamName", is(team2.teamName())));
    }

    @Test
    void whenNoAuthorizationReturnUnauthorized() throws Exception {
        //given
        TeamDTO team1 = TeamDTOMother.random();
        TeamDTO team2 = TeamDTOMother.random();
        when(useCase.find()).thenReturn(List.of(team1, team2));
        //then
        ResultActions result = mockMvc.perform(get("/api/v1/thermometer/team")
                .contentType(MediaType.APPLICATION_JSON));

        //then
        result.andExpect(status().isUnauthorized());
    }

    @TestConfiguration
    static class TestConfig {

        @Bean
        @Primary
        public FindAllTeamsUseCase useCase() {
            return Mockito.mock(FindAllTeamsUseCase.class);
        }
    }

}
