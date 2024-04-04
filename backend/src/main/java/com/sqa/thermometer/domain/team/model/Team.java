package com.sqa.thermometer.domain.team.model;

import lombok.Getter;

import java.util.Objects;
import java.util.UUID;

@Getter
public class Team {

    private final UUID id;
    private final String name;

    public Team(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Team create(UUID id, String name) {
        return new Team(id, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(id, team.id) && Objects.equals(name, team.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
