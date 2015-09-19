package me.machadolucas.questionnaire.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Questionnaire {

    @Id
    private String id;

    private Integer personId;

    private Integer age;
    private String gender;

    private Date creationDate = new Date();

    @DBRef
    private List<Question> questions;

    private Map<Integer, String> preferredDevices = new HashMap<>();

    private String moreInformation;

}
