package me.machadolucas.questionnaire.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import me.machadolucas.questionnaire.entity.Question;
import me.machadolucas.questionnaire.entity.Questionnaire;
import me.machadolucas.questionnaire.helper.QuestionsCreator;
import me.machadolucas.questionnaire.repository.QuestionRepository;
import me.machadolucas.questionnaire.repository.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;

@Theme("valo")
@SpringUI
public class Wizard extends UI {

    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    @Autowired
    private QuestionRepository questionRepository;

    Questionnaire questionnaire = new Questionnaire();

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
        Page.getCurrent().setTitle("Efeito do dispositivo de entrada na experiência de jogadores");
        configureComponents();
        buildLayout();
    }

    private void configureComponents() {

        wizardViewsList.add(new FirstWizardView());
        List<Question> questions = QuestionsCreator.createQuestions();
        for (Question question : questions) {
            wizardViewsList.add(new QuestionsView(question));
        }
        wizardViewsList.add(new LastWizardView());

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
            next.setCaption("Próximo");
            next.setStyleName(ValoTheme.BUTTON_PRIMARY);
            currentWizardViewIndex--;
            content.setContent(wizardViewsList.get(currentWizardViewIndex));
        }
        if (currentWizardViewIndex < 1) {
            previous.setEnabled(false);
        }

        progressBar.setValue((float) currentWizardViewIndex / wizardViewsList.size());
    }

    public void next(Button.ClickEvent event) {
        if (wizardViewsList.get(currentWizardViewIndex) instanceof QuestionsView) {
            QuestionsView currentView = (QuestionsView) wizardViewsList.get(currentWizardViewIndex);
            currentView.copySlidersValues();
        }
        if (currentWizardViewIndex < wizardViewsList.size() - 1) {
            previous.setEnabled(true);
            currentWizardViewIndex++;
            content.setContent(wizardViewsList.get(currentWizardViewIndex));
        } else {
            progressBar.setValue(1.0f);
            save();
        }
        if (currentWizardViewIndex == wizardViewsList.size() - 1) {
            next.setCaption("Enviar");
            next.setStyleName(ValoTheme.BUTTON_DANGER);
        }

        progressBar.setValue((float) currentWizardViewIndex / wizardViewsList.size());
    }

    private void save() {

        FirstWizardView firstView = (FirstWizardView) wizardViewsList.get(0);

        List<Question> questions = new LinkedList<>();
        final List<Question> questionsToInsert = questions;
        wizardViewsList.stream().filter(view -> view instanceof QuestionsView).forEach(view -> {
            QuestionsView questionView = (QuestionsView) view;
            questionsToInsert.add(questionView.getQuestion());

        });

        LastWizardView lastView = (LastWizardView) wizardViewsList.get(wizardViewsList.size() - 1);

        //save questions
        questions = questionRepository.insert(questionsToInsert);

        questionnaire.setQuestions(questions);
        questionnaire.setAge(new Integer(firstView.getAge().getValue()));
        questionnaire.setGender(firstView.getGender().getValue().toString());
        questionnaire.setMoreInformation(lastView.getMoreInformation().getValue());

        //save questionnaire
        questionnaireRepository.insert(questionnaire);

        configureComponents();
        buildLayout();

        String msg = "Respostas registradas com sucesso!";
        Notification.show(msg, Notification.Type.HUMANIZED_MESSAGE);
    }
}
