package me.machadolucas.questionnaire.entity;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

import org.springframework.data.annotation.Id;

@Data
public class Question {

    @Id
    private String id;

    private String name;

    private String title;
    private String description;

    private Map<String, Double> devices = new HashMap<>();

}
