package com.sqa.thermometer.service;

import com.sqa.thermometer.dto.TeamDTO;
import com.sqa.thermometer.model.Team;
import com.sqa.thermometer.repository.TeamRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private FabricaTeamService fabricaTeamService;

 /*   public TeamDTO save(TeamDTO teamDTO){
        return fabricaTeamService.createTeamDTO(teamRepository.save(fabricaTeamService.createTeam(teamDTO)));
    }*/

    public List<TeamDTO> findAll(){
        return fabricaTeamService.createTeamsDTO(teamRepository.findAll());
    }

    /*public TeamDTO findById(Integer id){
        return fabricaTeamService.createTeamDTO(teamRepository.findById(id).get());
    }

    public void deleteById(Integer id){
        teamRepository.deleteById(id);
    }*/
}
