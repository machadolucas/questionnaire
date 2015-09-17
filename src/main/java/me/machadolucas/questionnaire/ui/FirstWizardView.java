package me.machadolucas.questionnaire.ui;

import com.vaadin.ui.TextField;

public class FirstWizardView extends WizardViews {

    TextField idade = new TextField("Idade");
    TextField lastName = new TextField("Last name");

    public FirstWizardView() {
        configureComponents();
        buildLayout();
    }

    void configureComponents() {

    }

    void buildLayout() {
        setMargin(true);
        setSpacing(true);
        addComponents(idade, lastName);
    }
}
