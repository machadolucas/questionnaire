package me.machadolucas.questionnaire.entity;

import lombok.Data;

import org.springframework.data.annotation.Id;

@Data
public class Question {

    @Id
    private String id;

    private String title;
}
