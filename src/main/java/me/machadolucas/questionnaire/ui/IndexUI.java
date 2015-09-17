package me.machadolucas.questionnaire.ui;

import me.machadolucas.questionnaire.entity.Questionnaire;
import me.machadolucas.questionnaire.repository.QuestionnaireRepository;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.UI;

@Theme("valo")
@SpringUI
public class IndexUI extends UI {

    @Autowired
    public QuestionnaireRepository questionnaireRepository;

    Questionnaire questionnaire;

    // we can use either constructor autowiring or field autowiring
    @Autowired
    private SpringViewProvider viewProvider;

    @Override
    protected void init(VaadinRequest request) {
        configureComponents();
        buildLayout();
    }

    private void configureComponents() {

    }

    private void buildLayout() {
        Wizard wizard = new Wizard();

        wizard.setSizeFull();
        wizard.setMargin(true);
        wizard.setSpacing(true);
        setContent(wizard);

    }

}
