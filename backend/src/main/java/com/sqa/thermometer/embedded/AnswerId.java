package com.sqa.thermometer.embedded;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Data
public class AnswerId implements Serializable {

    @JdbcTypeCode(SqlTypes.CHAR)
    @UuidGenerator
    @Column(name = "id")
    private UUID Id;

    @JdbcTypeCode(SqlTypes.CHAR)
    @UuidGenerator
    @Column(name = "survey_id")
    private UUID surveyId;
 
    @JdbcTypeCode(SqlTypes.CHAR)
    @UuidGenerator
    @Column(name = "question_id")
    private UUID questionId;
}
