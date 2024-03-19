package com.sqa.thermometer.service;

import com.sqa.thermometer.dto.TeamDTO;
import com.sqa.thermometer.model.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FabricaTeamService {

    public Team createTeam(TeamDTO teamDTO){
        return new Team(teamDTO);
    }

   /* public TeamDTO createTeamDTO(Team team){
        return new TeamDTO(team);
    }*/

    public List<TeamDTO> createTeamsDTO(List<Team> teamList){
        List<TeamDTO> teamDTOList = new ArrayList<>();
        teamList.stream().forEach(
                team -> {
                    teamDTOList.add(new TeamDTO(team));
                }
        );
        return teamDTOList;
    }
}
