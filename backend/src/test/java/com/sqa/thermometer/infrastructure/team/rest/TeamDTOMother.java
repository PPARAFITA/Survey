package com.sqa.thermometer.infrastructure.team.rest;

import com.sqa.thermometer.shared.StringMother;

import java.util.UUID;

public class TeamDTOMother {

    public static TeamDTO create(UUID id, String name){
        return new TeamDTO(id, name);
    }

    public static TeamDTO random(){
        return create(UUID.randomUUID(), StringMother.createRandom(10));
    }
}
