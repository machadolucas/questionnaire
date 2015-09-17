package me.machadolucas.questionnaire.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import me.machadolucas.questionnaire.entity.Question;

public class QuestionsCreator {

    public static List<Question> createQuestions() {
        List<Question> questions = new ArrayList<>();

        Question captivation = new Question();
        captivation.setName("captivation");
        captivation.setTitle("Fascínio");
        captivation.setDescription("Esquecer o envolvimento com o ambiente, ficar compenetrado");
        questions.add(captivation);

        Question challenge = new Question();
        challenge.setName("challenge");
        challenge.setTitle("Desafio");
        challenge.setDescription("Habilidades testadas em um tarefa exigente");
        questions.add(challenge);

        Question competition = new Question();
        competition.setName("competition");
        competition.setTitle("Competição");
        competition.setDescription("Estar em competição com outro oponente");
        questions.add(competition);

        Collections.shuffle(questions);
        return questions;
    }
}
