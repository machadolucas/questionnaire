package me.machadolucas.questionnaire.ui;

import java.net.MalformedURLException;
import java.net.URL;

import me.machadolucas.questionnaire.entity.Question;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class QuestionsView extends WizardViews {

    Label title = new Label();
    Label description = new Label();
    Image image;

    Question question;

    public QuestionsView(Question question) {
        this.question = question;
        configureComponents();
        buildLayout();
    }

    void configureComponents() {
        try {
            image = new Image(null,
                    new ExternalResource(new URL("http://localhost:8080/" + question.getName() + ".png")));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        title.setValue(this.question.getTitle());
        description.setValue(this.question.getDescription());
    }

    void buildLayout() {
        title.setStyleName(ValoTheme.LABEL_H1);
        description.setStyleName(ValoTheme.LABEL_H3);

        VerticalLayout questionTextHead = new VerticalLayout();
        questionTextHead.setSpacing(true);
        questionTextHead.addComponents(title, description);

        HorizontalLayout questionHead = new HorizontalLayout();
        questionHead.setSpacing(true);
        questionHead.addComponents(image, questionTextHead);

        addComponents(questionHead);
    }
}
