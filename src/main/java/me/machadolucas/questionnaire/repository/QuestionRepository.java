package me.machadolucas.questionnaire.repository;

import me.machadolucas.questionnaire.entity.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionRepository extends MongoRepository<Question, String> {

}
