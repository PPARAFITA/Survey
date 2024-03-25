package com.sqa.thermometer.service;

import com.sqa.thermometer.dto.AnswerDTO;
import com.sqa.thermometer.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnswerService {

    @Autowired
    private FabricaAnswerService fabricaAnswerService;
    @Autowired
    private AnswerRepository answerRepository;

    public List<AnswerDTO> findAll(){
        return fabricaAnswerService.createAnswersDTO(answerRepository.findAll()) ;
    }

    public List<AnswerDTO> save(List<AnswerDTO> answerDTOList){

            answerRepository.saveAll(fabricaAnswerService.createAnswers(answerDTOList));
            return answerDTOList;

    }

}
