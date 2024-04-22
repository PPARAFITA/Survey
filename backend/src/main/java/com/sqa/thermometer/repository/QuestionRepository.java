package com.sqa.thermometer.repository;

import com.sqa.thermometer.dto.QuestionDTO;
import com.sqa.thermometer.model.Question;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, UUID> {

@Query( value =  "SELECT a.* FROM thermometer.question as a inner join thermometer.survey as b on a.survey_id = b.survey_id where b.team_id = :teamId" , nativeQuery = true )
List<Question> findQuestionsByTeam(@Param("teamId") String teamId );

}
