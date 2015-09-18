package me.machadolucas.questionnaire.ui;

import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;

public class FirstWizardView extends WizardViews {

    Label pageTitle = new Label("Efeito do dispositivo de entrada na experiência de jogadores");
    TextField idade = new TextField("Idade");
    TextField lastName = new TextField("Last name");

    Label instructionsForNextPage = new Label(
            "Será apresentada uma série de imagens que remetem a sensações e experiêncas que podem ou não ter ocorrido durante o teste. "
                    + "Avalie a intensidade de cada uma delas durante os testes, para cada dispositivo.");

    public FirstWizardView()

    {
        configureComponents();
        buildLayout();
    }

    void configureComponents() {

    }

    void buildLayout() {
        setMargin(true);
        setSpacing(true);

        pageTitle.setStyleName(ValoTheme.LABEL_H1);
        instructionsForNextPage.setStyleName(ValoTheme.LABEL_LARGE);

        addComponents(pageTitle, idade, lastName, instructionsForNextPage);
    }
}
