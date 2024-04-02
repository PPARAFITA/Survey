package com.sqa.thermometer.repository;

import com.sqa.thermometer.embedded.OptionId;
import com.sqa.thermometer.model.OptionQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends JpaRepository<OptionQuestion, OptionId> {
}
