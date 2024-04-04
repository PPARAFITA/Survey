package com.sqa.thermometer.infrastructure.team.rest;

import com.sqa.thermometer.domain.team.application.FindAllTeamsUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping
@RestController
public class GetAllTeamsController {

    private final FindAllTeamsUseCase findAllTeamsUseCase;

    public GetAllTeamsController(FindAllTeamsUseCase findAllTeamsUseCase) {
        this.findAllTeamsUseCase = findAllTeamsUseCase;
    }

    @GetMapping("/api/v1/thermometer/team")
    public ResponseEntity<List<TeamDTO>> findAll() {
        return new ResponseEntity<>(findAllTeamsUseCase.find(), HttpStatus.OK);
    }
}
