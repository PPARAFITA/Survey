package com.sqa.thermometer.infrastructure.team.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TeamRepositoryJPA extends JpaRepository<TeamEntity, UUID> {
}
