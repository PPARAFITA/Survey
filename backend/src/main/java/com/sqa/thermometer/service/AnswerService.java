package com.sqa.thermometer.service;

import com.sqa.thermometer.dto.AnswerDTO;
import com.sqa.thermometer.dto.ResultKPIDTO;
import com.sqa.thermometer.dto.ResultMonthDTO;
import com.sqa.thermometer.embedded.ResultTrafficLight;
import com.sqa.thermometer.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    //public addResult(){}

    public List<ResultMonthDTO> findByTeamAndMonth(String teamId, String month){
        List<Object[]> results = answerRepository.findByTeamAndMonth(teamId,04);
        List<ResultMonthDTO> resultDTO = new ArrayList<>();
        
        List<ResultTrafficLight> trafficLightList = new ArrayList<>();
        String color ;  
        Long count ;
        String question_id;
        String question;
        String questionType;
        int totalLines = results.size();
        int cantLines = 0;

       // Map<String, List<Object[]>> groupByQuestion = results.stream().collect(Collectors.groupingBy(Object[] :: result.));
        
        //Object[] firstResult = results[0];
        Object[] previousRecord = results.get(0);
        
       
        for( Object[] result: results) {
            
            cantLines ++;

            String actualQuestion = (String) result[2];
            String previousQuestionId = (String) previousRecord[2];

            if( ! actualQuestion.equals(previousQuestionId)  ){
                List<ResultTrafficLight> trafficResultList = new ArrayList<>(trafficLightList);
                
                question_id = (String) previousRecord[2];
                question = (String) previousRecord[3];
                questionType = (String) previousRecord[4];

                ResultMonthDTO dtoRecord = new ResultMonthDTO( question_id, question, questionType, trafficResultList);
                resultDTO.add(dtoRecord);
                trafficLightList.clear();
                previousRecord = result;
            }
            
            color = (String) result[0];  
            count = (Long) result[1];

            ResultTrafficLight trafficLight = new ResultTrafficLight(color, count);
            trafficLightList.add(trafficLight);

            if(  totalLines == cantLines ){
                List<ResultTrafficLight> trafficResultList = new ArrayList<>(trafficLightList);
                
                question_id = (String) result[2];
                question = (String) result[3];
                questionType = (String) result[4];

                ResultMonthDTO dtoRecord = new ResultMonthDTO( question_id, question, questionType, trafficResultList);
                resultDTO.add(dtoRecord);
                trafficLightList.clear();
                previousRecord = result;                
            }
        }

        return resultDTO;        
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

    // public List<ResultMonthDTO> findByTeamAndMonth(String teamId, String month){
       
    //     List<Object[]> results = answerRepository.findByTeamAndMonth(teamId,04);
    //     List<ResultMonthDTO> resultDTO = new ArrayList<>();

    //     for( Object[] result: results) {
    //         String color = (String) result[0];
    //         Long count = (Long) result[1];
    //         Integer month2 = (Integer) result[2];

    //         ResultKPIDTO dtoRecord = new ResultKPIDTO( color, count.intValue(), month2);

    //         resultDTO.add(dtoRecord);

    //     }

    //     return resultDTO;
    // }

}
