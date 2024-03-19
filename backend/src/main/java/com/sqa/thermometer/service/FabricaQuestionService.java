package com.sqa.thermometer.service;

import com.sqa.thermometer.dto.QuestionDTO;
import com.sqa.thermometer.model.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FabricaQuestionService {

    public Question createQuestion(QuestionDTO questionDTO){
        return new Question(questionDTO);
    }
    public QuestionDTO createQuestionDTO(Question question){
        return new QuestionDTO(question);
    }

    public List<QuestionDTO> createQuestionsDTO(List<Question> questionList){
        List<QuestionDTO> questionDTOList = new ArrayList<>();

        questionList.stream().forEach(
                question -> {
                    questionDTOList.add(createQuestionDTO(question));
                }
        );
        return questionDTOList;
    }
}
