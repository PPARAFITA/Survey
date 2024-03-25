package com.sqa.thermometer.dto;

import com.sqa.thermometer.model.Question;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class QuestionDTO {
    private UUID questionId;
    private String question;
    private String questionType;
    // private Integer optionId;
    // private String valorOption;
    // private String color;
    private List<OptionDTO> optionDTOList;

    public QuestionDTO(Question question){
        this.questionId = question.getQuestionId();
        this.question = question.getQuestion();
        this.questionType = question.getQuestionType();
        this.optionDTOList = new ArrayList<>();

        question.getOptionQuestion().stream().forEach( optionQuestion -> {
           // this.optionDTOList.add(new OptionDTO(optionQuestion));
           this.optionDTOList.add(new OptionDTO(optionQuestion));
        });
    
    }

        public QuestionDTO(QuestionDTO question){
            this.questionId = question.getQuestionId();
            this.question = question.getQuestion();
            this.questionType = question.getQuestionType();

            this.optionDTOList = new ArrayList<>();
            this.optionDTOList = question.getOptionDTOList();
            //this.optionDTOList = question.getOptionDTOList();

    }

}
