package me.machadolucas.questionnaire.ui;

import java.util.LinkedList;
import java.util.List;

import me.machadolucas.questionnaire.entity.Question;
import me.machadolucas.questionnaire.entity.Questionnaire;
import me.machadolucas.questionnaire.helper.QuestionsCreator;
import me.machadolucas.questionnaire.repository.QuestionnaireRepository;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.ProgressBar;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@Theme("valo")
@SpringUI
public class Wizard extends UI {

    @Autowired
    public QuestionnaireRepository questionnaireRepository;

    Questionnaire questionnaire;

    // =========================================================

    ProgressBar progressBar = new ProgressBar(0);
    Panel content = new Panel();

    VerticalLayout wizard = new VerticalLayout();
    List<WizardViews> wizardViewsList = new LinkedList<>();

    private int currentWizardViewIndex = 0;

    Button previous = new Button("Anterior", this::previous);
    Button next = new Button("Próximo", this::next);

    // =========================================================

    @Override
    protected void init(VaadinRequest vaadinRequest) {
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
        progressBar.setWidth("100%");

        HorizontalLayout bar = new HorizontalLayout();
        bar.addComponents(previous, next);
        bar.setExpandRatio(previous, 0);
        bar.setExpandRatio(next, 0);
        bar.setComponentAlignment(previous, Alignment.MIDDLE_LEFT);
        bar.setComponentAlignment(next, Alignment.MIDDLE_RIGHT);
        bar.setWidth("100%");

        content.setSizeFull();

        wizard.addComponents(progressBar, content, bar);
        wizard.setExpandRatio(content, 1);
        wizard.setSizeFull();
        wizard.setMargin(true);
        wizard.setSpacing(true);
        setContent(wizard);
    }

    // =================================================================================

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
