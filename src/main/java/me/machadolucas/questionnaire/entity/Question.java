package me.machadolucas.questionnaire.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.HashMap;
import java.util.Map;

@Data
public class Question {

    @Id
    private String id;

    @Indexed
    private String name;

    @Transient
    private String title;
    @Transient
    private String description;

    private Map<String, Double> devices = new HashMap<>();

}
