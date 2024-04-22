package com.sqa.thermometer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sqa.thermometer.embedded.AnswerId;
import com.sqa.thermometer.model.Answer;

@Repository
public interface ResultTrafficLightMonthRepository extends JpaRepository<Answer, AnswerId>{

} 
