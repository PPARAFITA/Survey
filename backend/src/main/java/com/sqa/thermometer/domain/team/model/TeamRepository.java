package com.sqa.thermometer.domain.team.model;

import java.util.List;
import java.util.UUID;

public interface TeamRepository {

    void save(Team team);

    Team find(UUID id);

    List<Team> findAll();

    void delete(UUID id);
}
