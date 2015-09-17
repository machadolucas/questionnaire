package me.machadolucas.questionnaire.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class Questionnaire {

    @Id
    private String id;

    private Integer age;
    private String gender;

    private List<Question> questions;

    private List<String> preferredDevices;

}
