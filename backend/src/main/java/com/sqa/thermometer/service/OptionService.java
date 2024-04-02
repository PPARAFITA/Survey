package com.sqa.thermometer.service;

import com.sqa.thermometer.dto.OptionDTO;
import com.sqa.thermometer.repository.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService {
    @Autowired
    private OptionRepository optionRepository;
    @Autowired
    private FabricaOptionService fabricaOptionService;


    public OptionDTO save(OptionDTO optionDTO){
        return fabricaOptionService.createOptionDTO(optionRepository.save(fabricaOptionService.createOption(optionDTO)));
    }
    public List<OptionDTO> findAll(){
        return fabricaOptionService.createOptionsDTO(optionRepository.findAll());
    }

    // public OptionDTO findById(Integer id){
    //     return fabricaOptionService.createOptionDTO(optionRepository.findById(id).get());
    // }
}

