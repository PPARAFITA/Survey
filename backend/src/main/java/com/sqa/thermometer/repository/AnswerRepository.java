package com.sqa.thermometer.repository;

import com.sqa.thermometer.dto.ResultKPIDTO;
import com.sqa.thermometer.embedded.AnswerId;
import com.sqa.thermometer.model.Answer;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface AnswerRepository extends JpaRepository<Answer, AnswerId> {

    
    // @query( value = " select count(*) as cant, color from thermometer.answer as a left join thermometer.option_question as b on a.option_id = b.option_id and a.survey_id = b.survey_id   group by a.question_id, color;  ", nativeQuery = true )
    // int countPositiveResponses();

     @Query(value = "select color, count(*) as count, MONTH(creation_date) as month from thermometer.answer as a left join thermometer.option_question as b on a.option_id = b.option_id and a.survey_id = b.survey_id where a.question_id = :questionId AND MONTH(creation_date) = :month group by color, MONTH(creation_date) order by color", nativeQuery = true)
     List<Object[]> findByIdAndMonth(@Param("questionId") String questionId ,@Param("month") Integer month);

    //  @Query(value = "select  color, count(*) as count, c.question_id, c.question, question_type from thermometer.answer as a left join thermometer.option_question as b on a.option_id = b.option_id and a.survey_id = b.survey_id inner join thermometer.question as c on c.question_id = a.question_id  where a.survey_id = (select survey_id from thermometer.survey where team_id = :teamId ) AND MONTH(creation_date) = 04 group by c.question_id, c.question, color order by color", nativeQuery = true)
    //  List<Object[]> findByTeamAndMonth(@Param("teamId") String teamId ,@Param("month") Integer month);


}
