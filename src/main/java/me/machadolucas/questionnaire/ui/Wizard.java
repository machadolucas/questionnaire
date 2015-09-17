package me.machadolucas.questionnaire.ui;

import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by machadolucas on 16/09/15.
 */
public class Wizard extends VerticalLayout {

    ProgressBar progressBar = new ProgressBar(0);
    Panel content = new Panel();

    List<WizardViews> wizardViewsList = new ArrayList<>();


    HorizontalLayout bar = new HorizontalLayout();
    private int currentWizardViewIndex = 0;

    Button previous = new Button("Anterior", this::previous);
    Button next = new Button("Próximo", this::next);


    public Wizard() {
        configureComponents();
        buildLayout();
    }

    private void configureComponents() {

        bar.addComponents(previous, next);
        bar.setSpacing(true);

        wizardViewsList.add(new FirstWizardView());

        next.setStyleName(ValoTheme.BUTTON_PRIMARY);
//        next.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        content.setContent(wizardViewsList.get(currentWizardViewIndex));


    }

    private void buildLayout() {
        setSizeFull();
        setMargin(true);

//        HorizontalLayout actions = new HorizontalLayout(salvar, cancelar);
//        actions.setSpacing(true);

        addComponents(progressBar, content, bar);
    }

    public void previous(Button.ClickEvent event) {
        content.setContent(wizardViewsList.get(currentWizardViewIndex));
    }

    public void next(Button.ClickEvent event) {
        content.setContent(wizardViewsList.get(currentWizardViewIndex));
    }

    public void save(Button.ClickEvent event) {
        // Commit the fields from UI to DAO
//            formFieldBindings.commit();

        // Save DAO to backend with direct synchronous service API
//        getUI().questionnaireRepository.salvar(contact);

        String msg = "Respostas registradas com sucesso!";
        Notification.show(msg, Notification.Type.TRAY_NOTIFICATION);
//            getUI().refreshContacts();
    }

    public void cancel(Button.ClickEvent event) {
        // Place to call business logic.
        Notification.show("Cancelled", Notification.Type.TRAY_NOTIFICATION);
//        getUI().contactList.select(null);
    }
}
