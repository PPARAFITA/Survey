package com.sqa.thermometer.domain.team.model;

import com.sqa.thermometer.shared.StringMother;

import java.util.UUID;

public class TeamMother {

    public static Team create(UUID id, String name) {
        return new Team(id, name);
    }

    public static Team random() {
        return create(UUID.randomUUID(), StringMother.createRandom(7));
    }

}