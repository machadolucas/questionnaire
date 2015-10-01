package me.machadolucas.questionnaire;

import java.util.List;

import javax.annotation.PostConstruct;

import me.machadolucas.questionnaire.entity.Question;
import me.machadolucas.questionnaire.entity.Questionnaire;
import me.machadolucas.questionnaire.repository.QuestionRepository;
import me.machadolucas.questionnaire.repository.QuestionnaireRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class QuestionnaireApplication {

    @Autowired
    QuestionnaireRepository questionnaireRepository;
    @Autowired
    QuestionRepository questionRepository;

    public static void main(String[] args) {
        SpringApplication.run(QuestionnaireApplication.class, args);
    }

    @PostConstruct
    public void runOperations() {

        final String DELIMITER = "\t";

        List<Questionnaire> surveys = questionnaireRepository.findAll();
        StringBuilder data = new StringBuilder( //
                "PersonID" + DELIMITER + //
                        "Age" + DELIMITER + //
                        "Gender" + DELIMITER + //
                        "ExperienceInGame" + DELIMITER + //
                        "ExperienceInMouse" + DELIMITER + //
                        "ExperienceInTouch" + DELIMITER + //
                        "ExperienceInGamepad" + DELIMITER + //
                        "ExperienceInKinect" + DELIMITER + //
                        "Favorite1" + DELIMITER + //
                        "Favorite2" + DELIMITER + //
                        "Favorite3" + DELIMITER + //
                        "Favorite4" + DELIMITER + //
                        "Question" + DELIMITER + //
                        "Mouse" + DELIMITER + //
                        "Touch" + DELIMITER + //
                        "Gamepad" + DELIMITER + //
                        "Kinect\n");

        for (Questionnaire quest : surveys) {

            for (Question q : quest.getQuestions()) {
                data.append(quest.getPersonId()).append(DELIMITER);
                data.append(quest.getAge()).append(DELIMITER);
                data.append(quest.getGender()).append(DELIMITER);
                data.append(quest.getXpGame()).append(DELIMITER);
                data.append(quest.getXpMouse()).append(DELIMITER);
                data.append(quest.getXpTouch()).append(DELIMITER);
                data.append(quest.getXpGamepad()).append(DELIMITER);
                data.append(quest.getXpKinect()).append(DELIMITER);
                data.append(quest.getPreferredDevices().get(1)).append(DELIMITER);
                data.append(quest.getPreferredDevices().get(2)).append(DELIMITER);
                data.append(quest.getPreferredDevices().get(3)).append(DELIMITER);
                data.append(quest.getPreferredDevices().get(4)).append(DELIMITER);
                data.append(q.getName()).append(DELIMITER);
                data.append(q.getDevices().get("Mouse").intValue()).append(DELIMITER);
                data.append(q.getDevices().get("Toque").intValue()).append(DELIMITER);
                data.append(q.getDevices().get("Gamepad").intValue()).append(DELIMITER);
                data.append(q.getDevices().get("Kinect").intValue()).append("\n");
            }

        }

        System.out.println(data.toString());
    }
}
