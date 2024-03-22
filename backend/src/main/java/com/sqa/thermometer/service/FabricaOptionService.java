package com.sqa.thermometer.service;

import org.springframework.stereotype.Service;
import com.sqa.thermometer.dto.OptionDTO;
import com.sqa.thermometer.model.OptionQuestion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FabricaOptionService {

    public OptionQuestion createOption(OptionDTO optionDTO){
        return new OptionQuestion(optionDTO);
    }

    public OptionDTO createOptionDTO(OptionQuestion option){
        return new OptionDTO(option);
    }

    public List<OptionDTO> createOptionsDTO(List<OptionQuestion> optionList){
        List<OptionDTO> optionDTOList = new ArrayList<>();

        optionList.stream().forEach(
                option -> {
                    optionDTOList.add(new OptionDTO(option));
                }
        );
        return optionDTOList;
    }

    public List<OptionQuestion> createOptions(List<OptionDTO> optionDTOList){
        List<OptionQuestion> optionList = new ArrayList<>();

        optionDTOList.stream().forEach(
                optionDTO -> {
                    optionList.add(new OptionQuestion(optionDTO));
                }
        );
        return optionList;
    }
}
