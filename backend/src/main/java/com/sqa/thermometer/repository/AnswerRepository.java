package com.sqa.thermometer.repository;

import com.sqa.thermometer.embedded.AnswerId;
import com.sqa.thermometer.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AnswerRepository extends JpaRepository<Answer, AnswerId> {
}
