package com.sqa.thermometer.model;

import com.sqa.thermometer.dto.TeamDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.CHAR)
    @UuidGenerator
    private UUID teamId;

    private String teamName;

    public Team(TeamDTO teamDTO) {
        this.teamId = teamDTO.getTeamId();
        this.teamName = teamDTO.getTeamName();

    }
}
