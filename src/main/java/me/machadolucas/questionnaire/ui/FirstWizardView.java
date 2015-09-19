package me.machadolucas.questionnaire.ui;

import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;
import lombok.Getter;

public class FirstWizardView extends WizardViews {

    Label pageTitle = new Label("Efeito do dispositivo de entrada na experiência de jogadores");

    @Getter
    TextField age = new TextField("Sua idade");

    @Getter
    NativeSelect gender = new NativeSelect("Identidade de gênero");


    Label instructionsForNextPage1 = new Label(
            "Nas próximas etapas será apresentada uma série de 22 imagens que remetem a sensações e experiências que podem ou não ter ocorrido durante o teste.");
    Label instructionsForNextPage2 = new Label("Avalie a intensidade de cada uma delas durante os testes, para cada dispositivo.");

    public FirstWizardView()

    {
        configureComponents();
        buildLayout();
    }

    void configureComponents() {
        age.setInputPrompt("00");

        gender.addItem(1);
        gender.setItemCaption(1, "Prefiro não responder");
        gender.addItem(2);
        gender.setItemCaption(2, "Feminino");
        gender.addItem(3);
        gender.setItemCaption(3, "Masculino");
        gender.addItem(4);
        gender.setItemCaption(4, "Sem gênero");

    }

    void buildLayout() {
        setMargin(true);
        setSpacing(true);

        pageTitle.setStyleName(ValoTheme.LABEL_H1);
        instructionsForNextPage1.setStyleName(ValoTheme.LABEL_LARGE);
        instructionsForNextPage2.setStyleName(ValoTheme.LABEL_LARGE);

        Label gap = new Label();
        gap.setHeight("5em");

        addComponents(pageTitle, age, gender, gap, instructionsForNextPage1, instructionsForNextPage2);
    }
}
