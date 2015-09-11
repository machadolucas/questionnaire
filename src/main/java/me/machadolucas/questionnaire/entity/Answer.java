package me.machadolucas.questionnaire.entity;

import lombok.Data;

import org.springframework.data.annotation.Id;

@Data
public class Answer {

    @Id
    private String id;

    private String age;

    private String gender;
}
