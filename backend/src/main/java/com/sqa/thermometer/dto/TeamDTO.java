package com.sqa.thermometer.dto;

import com.sqa.thermometer.model.Team;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Data
@NoArgsConstructor
public class TeamDTO {
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID teamId;
    private String teamName;


    public TeamDTO(Team team){
        this.teamId = team.getTeamId();
        this.teamName = team.getTeamName();
    }

}
