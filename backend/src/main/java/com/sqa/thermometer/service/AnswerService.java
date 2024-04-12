package com.sqa.thermometer.service;

import com.sqa.thermometer.dto.AnswerDTO;
import com.sqa.thermometer.dto.ResultKPIDTO;
import com.sqa.thermometer.dto.ResultMonthDTO;
import com.sqa.thermometer.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    public List<ResultKPIDTO> findByIdAndMonth(String questionId, String month){
       
        List<Object[]> results = answerRepository.findByIdAndMonth(questionId,04);
        List<ResultKPIDTO> resultDTO = new ArrayList<>();

        for( Object[] result: results) {
            String color = (String) result[0];
            Long count = (Long) result[1];
            Integer month2 = (Integer) result[2];

            ResultKPIDTO dtoRecord = new ResultKPIDTO( color, count.intValue(), month2);

            resultDTO.add(dtoRecord);

        }

        return resultDTO;
    }

    public List<ResultMonthDTO> findByTeamAndMonth(String teamId, String month){
       
        List<Object[]> results = answerRepository.findByTeamAndMonth(teamId,04);
        List<ResultMonthDTO> resultDTO = new ArrayList<>();

        for( Object[] result: results) {
            String color = (String) result[0];
            Long count = (Long) result[1];
            Integer month2 = (Integer) result[2];

            ResultKPIDTO dtoRecord = new ResultKPIDTO( color, count.intValue(), month2);

            resultDTO.add(dtoRecord);

        }

        return resultDTO;
    }

}
