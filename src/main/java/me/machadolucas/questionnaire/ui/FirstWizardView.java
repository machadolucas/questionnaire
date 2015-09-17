package me.machadolucas.questionnaire.ui;

import com.vaadin.ui.DateField;
import com.vaadin.ui.TextField;

/**
 * Created by machadolucas on 16/09/15.
 */
public class FirstWizardView extends WizardViews {

    TextField idade = new TextField("Idade");
    TextField lastName = new TextField("Last name");
    TextField phone = new TextField("Phone");
    TextField email = new TextField("Email");
    DateField birthDate = new DateField("Birth date");


    public FirstWizardView() {
        configureComponents();
        buildLayout();
    }

    void configureComponents() {

    }

    void buildLayout() {
        addComponents(idade, lastName, phone, email, birthDate);
    }
}
