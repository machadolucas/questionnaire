package me.machadolucas.questionnaire.ui;

import java.util.LinkedList;
import java.util.List;

import me.machadolucas.questionnaire.entity.Question;
import me.machadolucas.questionnaire.helper.QuestionsCreator;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.ProgressBar;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class Wizard extends VerticalLayout {

    ProgressBar progressBar = new ProgressBar(0);
    Panel content = new Panel();

    List<WizardViews> wizardViewsList = new LinkedList<>();

    private int currentWizardViewIndex = 0;

    Button previous = new Button("Anterior", this::previous);
    Button next = new Button("Próximo", this::next);

    public Wizard() {
        configureComponents();
        buildLayout();
    }

    private void configureComponents() {

        wizardViewsList.add(new FirstWizardView());
        List<Question> questions = QuestionsCreator.createQuestions();
        for (Question question : questions) {
            wizardViewsList.add(new QuestionsView(question));
        }

        previous.setEnabled(false);

        next.setStyleName(ValoTheme.BUTTON_PRIMARY);
        // next.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        content.setContent(wizardViewsList.get(currentWizardViewIndex));

    }

    private void buildLayout() {
        setSizeFull();
        setMargin(true);

        progressBar.setWidth("100%");

        HorizontalLayout bar = new HorizontalLayout();
        bar.addComponents(previous, next);
        bar.setSpacing(true);
        bar.setWidth("100%");

        content.setSizeFull();

        addComponents(progressBar, content, bar);
    }

    public void previous(Button.ClickEvent event) {
        if (currentWizardViewIndex > 0) {
            next.setEnabled(true);
            currentWizardViewIndex--;
            content.setContent(wizardViewsList.get(currentWizardViewIndex));
        }
        if (currentWizardViewIndex < 1) {
            previous.setEnabled(false);
        }

        progressBar.setValue((float) currentWizardViewIndex / wizardViewsList.size());
    }

    public void next(Button.ClickEvent event) {
        if (currentWizardViewIndex < wizardViewsList.size() - 1) {
            previous.setEnabled(true);
            currentWizardViewIndex++;
            content.setContent(wizardViewsList.get(currentWizardViewIndex));
        }
        if (currentWizardViewIndex == wizardViewsList.size() - 1) {
            next.setEnabled(false);
        }

        progressBar.setValue((float) currentWizardViewIndex / wizardViewsList.size());
    }

    public void save(Button.ClickEvent event) {
        // Commit the fields from UI to DAO
        // formFieldBindings.commit();

        // Save DAO to backend with direct synchronous service API
        // getUI().questionnaireRepository.salvar(contact);

        String msg = "Respostas registradas com sucesso!";
        Notification.show(msg, Notification.Type.TRAY_NOTIFICATION);
        // getUI().refreshContacts();
    }

    public void cancel(Button.ClickEvent event) {
        // Place to call business logic.
        Notification.show("Cancelled", Notification.Type.TRAY_NOTIFICATION);
        // getUI().contactList.select(null);
    }
}
