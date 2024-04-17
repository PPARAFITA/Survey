package com.sqa.thermometer.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sqa.thermometer.dto.ResultMonthDTO;
import com.sqa.thermometer.embedded.AnswerId;
import com.sqa.thermometer.embedded.ResultTrafficLight;
import com.sqa.thermometer.model.Answer;

@Repository
public interface ResultTrafficLightMonthRepository extends JpaRepository<Answer, AnswerId>{

    //select count(*) as cant, color, a.question_id from thermometer.answer as a left join thermometer.option_question as b on a.option_id = b.option_id and a.survey_id = b.survey_id   group by a.question_id, color;
} 
