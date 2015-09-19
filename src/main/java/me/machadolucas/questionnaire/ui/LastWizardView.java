package me.machadolucas.questionnaire.ui;

import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.themes.ValoTheme;
import lombok.Getter;

public class LastWizardView extends WizardViews {

    Label pageTitle = new Label("Concluindo...");

    // Quais os melhores dispositivos para jogar?

    // Segundo sua experiência no jogo Fruit Ninja, ordene os dispositivos do melhor ao pior

    @Getter
    TextArea moreInformation = new TextArea("Há mais alguma informação sobre suas experiência que você gostaria que fosse considerada? (Opcional)");
    // Caso você tenha notado algo importante que não foi levado em conta nas questões anteriores


    public LastWizardView()

    {
        configureComponents();
        buildLayout();
    }

    void configureComponents() {

        moreInformation.setRows(5);
        moreInformation.setWordwrap(true);
        moreInformation.setWidth("500px");

    }

    void buildLayout() {
        setMargin(true);
        setSpacing(true);

        pageTitle.setStyleName(ValoTheme.LABEL_H1);

        addComponents(pageTitle, moreInformation);
    }
}
