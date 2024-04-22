package com.sqa.thermometer.repository;

import com.sqa.thermometer.dto.ResultKPIDTO;
import com.sqa.thermometer.embedded.AnswerId;
import com.sqa.thermometer.model.Answer;
import java.util.List;

import org.antlr.v4.runtime.atn.SemanticContext.AND;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface AnswerRepository extends JpaRepository<Answer, AnswerId> {


     @Query(value = "select a.question_id, color, count(*) as count, Month(creation_date) as fecha, c.question_type from thermometer.answer as a left join thermometer.option_question as b on a.option_id = b.option_id and a.survey_id = b.survey_id" + 
                    " inner join thermometer.question as c on c.question_id = b.question_id where a.question_id = :questionId AND " + "a.survey_id = (select survey_id from thermometer.survey where team_id = :teamId ) " + 
                    " group by a.question_id, color, fecha, c.question_type  order by a.question_id, fecha ", nativeQuery = true)
     List<Object[]> findByTeamAndQuestion(@Param("teamId") String teamId, @Param("questionId") String questionId );

     
    @Query(value = "select  color, count(*) as count, c.question_id, c.question, question_type from thermometer.answer as a left join thermometer.option_question as b on a.option_id = b.option_id and a.survey_id = b.survey_id inner join thermometer.question as c on c.question_id = a.question_id  where a.survey_id = (select survey_id from thermometer.survey where team_id = :teamId ) AND MONTH(creation_date) = :month group by c.question_id, c.question, color order by c.question_id", nativeQuery = true)
    List<Object[]> findByTeamAndMonth(@Param("teamId") String teamId ,@Param("month") Integer month);


    @Query(value = " select count(*) as count from thermometer.answer as a inner join thermometer.question as b on b.question_id = a.question_id " + 
                   " where a.question_id = :questionId AND a.survey_id = (select survey_id from thermometer.survey where team_id = :teamId ) " +
                   " AND YEAR(a.creation_date) = YEAR(NOW()) " , nativeQuery = true)
    Integer totalAnswersByYear(@Param("teamId") String teamId, @Param("questionId") String questionId );

}
