package com.sqa.thermometer.infrastructure.team.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name = "team")
public class TeamEntity {

    @Id
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID teamId;

    @Column(name = "team_name", unique = true, nullable = false)
    private String teamName;

    public TeamEntity(UUID teamId, String teamName) {
        this.teamId = teamId;
        this.teamName = teamName;
    }
}
