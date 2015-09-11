package me.machadolucas.questionnaire.repository;

import me.machadolucas.questionnaire.entity.Answer;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnswerRepository extends MongoRepository<Answer, String> {
}
