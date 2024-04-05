package com.sqa.thermometer.service;

import com.sqa.thermometer.dto.AnswerDTO;
import com.sqa.thermometer.model.Answer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FabricaAnswerService {

    public Answer createAnswer(AnswerDTO answerDTO){
        return new Answer(answerDTO);
    }

    public AnswerDTO createAnswerDTO(Answer answer){
        return new AnswerDTO(answer);
    }

    public List<AnswerDTO> createAnswersDTO(List<Answer> answerList){
        List<AnswerDTO> answerDTOList = new ArrayList<>();

        answerList.stream().forEach(
                answer -> {
                    answerDTOList.add(new AnswerDTO(answer));
                }
        );
        return answerDTOList;
    }

    public List<Answer> createAnswers(List<AnswerDTO> answerDTOList){
        List<Answer> answerList = new ArrayList<>();
        UUID uuid = UUID.randomUUID();
        answerDTOList.stream().forEach(
                answerDTO -> {
                    answerDTO.setAnswerId( uuid );
                    answerList.add(new Answer(answerDTO));
                }
        );
        return answerList;
    }
}
