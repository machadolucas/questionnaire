package me.machadolucas.questionnaire.ui;

import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;

public class LastWizardView extends WizardViews {

    Label pageTitle = new Label("Efeito do dispositivo de entrada na experiência de jogadores");
    TextField idade = new TextField("Idade");

    // Quais os melhores dispositivos para jogar?

    // Segundo sua experiência no jogo Fruit Ninja, ordene os dispositivos do melhor ao pior

    TextField lastName = new TextField("Há mais alguma informação que você gostaria que fosse considerada?");
    // Caso você tenha notado algo importante que não foi levado em conta nas questões anteriores

    Label instructionsForNextPage = new Label(
            "Será apresentada uma série de imagens que remetem a sensações e experiêncas que podem ou não ter ocorrido durante o teste. "
                    + "Avalie a intensidade de cada uma delas durante os testes, para cada dispositivo.");

    public LastWizardView()

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
