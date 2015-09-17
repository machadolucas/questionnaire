package me.machadolucas.questionnaire.ui;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import me.machadolucas.questionnaire.entity.Devices;
import me.machadolucas.questionnaire.entity.Question;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Slider;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class QuestionsView extends WizardViews {

    Label title = new Label();
    Label description = new Label();
    Label instructions = new Label();
    Image image;

    Question question;

    List<Slider> sliders = new LinkedList<>();

    public QuestionsView(Question question) {
        this.question = question;

        configureComponents();
        buildLayout();
    }

    void configureComponents() {
        image = new Image(null, new ExternalResource("http://localhost:8080/" + question.getName() + ".png"));

        title.setValue(this.question.getTitle());
        description.setValue(this.question.getDescription());
        instructions.setValue("Para cada dispositivo, selecione a intensidade de " + this.question.getTitle());

        for (Devices device : Devices.values()) {
            sliders.add(new Slider(device.getName()));
        }
        Collections.shuffle(sliders);
    }

    void buildLayout() {

        title.setStyleName(ValoTheme.LABEL_H1);
        description.setStyleName(ValoTheme.LABEL_H3);

        VerticalLayout questionTextHead = new VerticalLayout();
        questionTextHead.setSpacing(true);
        questionTextHead.addComponents(title, description, instructions);
        for (Slider slider : sliders) {
            slider.setWidth("400px");
            questionTextHead.addComponent(slider);
        }

        HorizontalLayout questionForm = new HorizontalLayout();
        questionForm.setSpacing(true);
        questionForm.setMargin(true);
        questionForm.addComponents(image, questionTextHead);

        addComponents(questionForm);
    }
}
