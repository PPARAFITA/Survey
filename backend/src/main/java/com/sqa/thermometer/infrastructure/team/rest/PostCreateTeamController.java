package com.sqa.thermometer.infrastructure.team.rest;

import com.sqa.thermometer.domain.team.application.CreateTeamUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequestMapping
@RestController
public class PostCreateTeamController {

    private final CreateTeamUseCase createTeamUseCase;

    public PostCreateTeamController(CreateTeamUseCase createTeamUseCase) {
        this.createTeamUseCase = createTeamUseCase;
    }


    @PostMapping("/api/v1/thermometer/team")
    public ResponseEntity<Void> save(@RequestBody TeamDTO teamDTO) {
        createTeamUseCase.create(teamDTO);
        return ResponseEntity.created(URI.create("/api/v1/thermometer/team/" + teamDTO.teamId().toString())).build();
    }
}
