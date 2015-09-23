package me.machadolucas.questionnaire.ui;

import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import lombok.Getter;

public class FirstWizardView extends WizardViews {

    Label pageTitle = new Label("Efeito do dispositivo de entrada na experiência de jogadores");

    @Getter
    TextField age = new TextField("Sua idade");

    @Getter
    NativeSelect gender = new NativeSelect("Identidade de gênero");

    @Getter
    NativeSelect xpGame = new NativeSelect("Experiência anterior com jogo Fruit Ninja");
    @Getter
    NativeSelect xpMouse = new NativeSelect("Experiência anterior com dispositivo Mouse");
    @Getter
    NativeSelect xpGamepad = new NativeSelect("Experiência anterior com dispositivo Gamepad");
    @Getter
    NativeSelect xpTouch = new NativeSelect("Experiência anterior com dispositivos de Toque");
    @Getter
    NativeSelect xpKinect = new NativeSelect("Experiência anterior com dispositivo Kinect");


    Label instructionsForNextPage1 = new Label(
            "Nas próximas etapas será apresentada uma série de 22 imagens que remetem a sensações e experiências que podem ou não ter ocorrido durante o teste.");
    Label instructionsForNextPage2 = new Label("Avalie a intensidade de cada uma delas durante os testes, para cada dispositivo. Se não houve a experiência, deixe zerado. Você pode avançar e voltar nas etapas.");

    public FirstWizardView()

    {
        configureComponents();
        buildLayout();
    }

    void configureComponents() {
        age.setInputPrompt("00");
        age.setRequired(true);

        gender.addItem(1);
        gender.setItemCaption(1, "Prefiro não responder");
        gender.addItem(2);
        gender.setItemCaption(2, "Feminino");
        gender.addItem(3);
        gender.setItemCaption(3, "Masculino");
        gender.addItem(4);
        gender.setItemCaption(4, "Sem gênero");
        gender.setRequired(true);

        addXpOptions(this.xpGame);
        addXpOptions(this.xpMouse);
        addXpOptions(this.xpGamepad);
        addXpOptions(this.xpTouch);
        addXpOptions(this.xpKinect);

    }

    void buildLayout() {
        setMargin(true);
        setSpacing(true);

        pageTitle.setStyleName(ValoTheme.LABEL_H1);
        instructionsForNextPage1.setStyleName(ValoTheme.LABEL_LARGE);
        instructionsForNextPage2.setStyleName(ValoTheme.LABEL_LARGE);

        Label gap = new Label();
        gap.setHeight("2em");

        HorizontalLayout hor = new HorizontalLayout();
        VerticalLayout ver1 = new VerticalLayout();
        VerticalLayout ver2 = new VerticalLayout();

        ver1.addComponents(age, gender);
        ver2.addComponents(xpGame, xpMouse, xpGamepad, xpTouch, xpKinect);
        hor.setSpacing(true);
        ver1.setSpacing(true);
        ver2.setSpacing(true);
        ver1.setMargin(true);
        ver2.setMargin(true);

        hor.addComponents(ver1, ver2);
        addComponents(pageTitle, hor, gap,
                instructionsForNextPage1, instructionsForNextPage2);
    }

    void addXpOptions(NativeSelect select) {
        select.addItem(0);
        select.setItemCaption(0, "Nenhuma");
        select.addItem(1);
        select.setItemCaption(1, "Pouca");
        select.addItem(2);
        select.setItemCaption(2, "Média");
        select.addItem(3);
        select.setItemCaption(3, "Experiente");
        select.setRequired(true);
    }

}
