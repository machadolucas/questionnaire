package me.machadolucas.questionnaire.repository;

import me.machadolucas.questionnaire.entity.Questionnaire;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionnaireRepository extends MongoRepository<Questionnaire, String> {
}
