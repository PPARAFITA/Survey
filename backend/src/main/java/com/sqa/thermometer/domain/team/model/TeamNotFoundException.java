package com.sqa.thermometer.domain.team.model;

import java.util.UUID;

public class TeamNotFoundException extends RuntimeException{

    public TeamNotFoundException(UUID teamId) {
        super("The team <"+teamId.toString()+"> not found");
    }
}
