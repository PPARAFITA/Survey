package com.sqa.thermometer.infrastructure.team.persistence;

import com.sqa.thermometer.shared.StringMother;

import java.util.UUID;

class TeamEntityMother {

    public static TeamEntity create(UUID id, String name) {
        return new TeamEntity(id, name);
    }

    public static TeamEntity random() {
        return create(UUID.randomUUID(), StringMother.createRandom(7));
    }
}