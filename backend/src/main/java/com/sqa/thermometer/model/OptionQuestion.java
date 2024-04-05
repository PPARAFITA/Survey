package com.sqa.thermometer.model;

import com.sqa.thermometer.embedded.OptionId;

import java.util.List;
import java.util.UUID;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;
import com.sqa.thermometer.dto.OptionDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class OptionQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.CHAR)
    @UuidGenerator
    @Column(name = "option_id")
    private UUID optionId;

    @ManyToOne
    @JoinColumn(name = "survey_id", insertable = false, updatable = false)
    private Survey survey;

    @ManyToOne
    @JoinColumn(name = "question_id", insertable = false, updatable = false)
    private Question question;

    private String valorOption;
   
    //@Enumerated(EnumType.STRING)
    //private TrafficLight color;
    private String color;

    /*Relacion entre option question y answer */
    @OneToMany(mappedBy = "option")
    private List<Answer> answerList;


    public OptionQuestion(OptionDTO optionDTO){
        this.optionId = optionDTO.getOptionId();
        this.valorOption = optionDTO.getValorOption();
        this.color = optionDTO.getColor();

    }

    public static enum TrafficLight{
        RED, ORANGE, GREEN;
    }
}
