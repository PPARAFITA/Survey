package com.sqa.thermometer.controller;

import com.sqa.thermometer.dto.TeamDTO;
import com.sqa.thermometer.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/api/v1/thermometer/team")
@RestController
public class TeamController {
    @Autowired
    private TeamService teamService;

 /*   @PostMapping("/save")
    public ResponseEntity<TeamDTO> save(@RequestBody TeamDTO teamDTO){
        return new ResponseEntity(teamService.save(teamDTO), HttpStatus.CREATED);
    }*/

    @GetMapping
    public ResponseEntity<List<TeamDTO>> findAll(){
        return new ResponseEntity<>(teamService.findAll(),HttpStatus.OK);
    }

/*    public ResponseEntity<TeamDTO> findById(@PathVariable Integer id){
        return new ResponseEntity<>(teamService.findById(id),HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Integer id){
        try{
            teamService.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/
}
