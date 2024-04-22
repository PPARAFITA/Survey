package com.sqa.thermometer.service;

import com.sqa.thermometer.dto.AnswerDTO;
import com.sqa.thermometer.dto.ResultKPIDTO;
import com.sqa.thermometer.dto.ResultMonthDTO;
import com.sqa.thermometer.embedded.ResultTrafficLight;
import com.sqa.thermometer.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
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

    public List<ResultKPIDTO> findByTeamAndQuestion(String teamId, String questionId){
        List<Object[]> results = answerRepository.findByTeamAndQuestion(teamId, questionId);
        List<ResultKPIDTO> resultKPIList = new ArrayList<>();

        if (!results.isEmpty()) {
            String previousMonth = null;
            ResultTrafficLight resultCount = new ResultTrafficLight(0L, 0L, 0L);
            String question_Id = null;
            int totalAnswers = 0;
          
            for (Object[] result : results) {
                String color = (String) result[1];
                Long count = (Long) result[2];    
                String month = String.valueOf(result[3]);
                String questiontype = (String) result[4];

                if (!month.equals(previousMonth)) {
                    if (previousMonth != null) {
                        resultKPIList.add(new ResultKPIDTO(question_Id, questiontype, MonthConverterService.convertMonthToChars(previousMonth), totalAnswers, resultCount));
                        resultCount = new ResultTrafficLight(0L, 0L, 0L);
                    }
                    previousMonth = month;
                    question_Id = (String) result[0];   
                    totalAnswers = 0;                           
                }

                totalAnswers += count;

                if ("red".equals(color)) {
                    resultCount.setRed(count);
                } else if ("green".equals(color)) {
                    resultCount.setGreen(count);
                } else if ("orange".equals(color)) {
                    resultCount.setOrange(count);
                }

                if (results.indexOf(result) == results.size() - 1) {
                    resultKPIList.add(new ResultKPIDTO(question_Id, questiontype, MonthConverterService.convertMonthToChars(month),totalAnswers, resultCount));
                    
                }
            }
        }

        return resultKPIList;
    }


    public List<ResultMonthDTO> findByTeamAndMonth(String teamId, String month) {
        List<Object[]> results = answerRepository.findByTeamAndMonth(teamId, MonthConverterService.convertirMesANumero(month));
        List<ResultMonthDTO> resultDTO = new ArrayList<>();
        
        if (!results.isEmpty()) {
            String previousQuestionId = null;
            ResultTrafficLight resultCount = new ResultTrafficLight(0L, 0L, 0L);
            String question = null;
            String questionType = null; 
            int totalAnswers = 0;

            for (Object[] result : results) {             
                String questionId = (String) result[2];
    
                if (!questionId.equals(previousQuestionId)) {
                    if (previousQuestionId != null) {
                        resultDTO.add(new ResultMonthDTO(previousQuestionId, question, questionType, totalAnswers, resultCount));
                        resultCount = new ResultTrafficLight(0L, 0L, 0L);
                    }
                    previousQuestionId = questionId;
                    question = (String) result[3];
                    questionType = (String) result[4];  
                    totalAnswers = 0;
                }

                String color = (String) result[0];
                Long count = (Long) result[1];
                
                totalAnswers += count;

                if ("red".equals(color)) {
                    resultCount.setRed(count);
                } else if ("green".equals(color)) {
                    resultCount.setGreen(count);
                } else if ("orange".equals(color)) {
                    resultCount.setOrange(count);
                }

                if (results.indexOf(result) == results.size() - 1) {
                    resultDTO.add(new ResultMonthDTO(questionId, question, questionType, totalAnswers, resultCount));
                    totalAnswers = 0; 
                }
            }
        }

        return resultDTO;
    }


    public Integer getTotalAnswerByYear(String teamId, String questionId){
        return answerRepository.totalAnswersByYear(teamId, questionId);
    }

}
