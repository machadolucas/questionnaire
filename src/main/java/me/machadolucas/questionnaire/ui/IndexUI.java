package me.machadolucas.questionnaire.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import me.machadolucas.questionnaire.entity.Questionnaire;
import me.machadolucas.questionnaire.repository.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Theme("valo")
@SpringUI
public class IndexUI extends UI {

    @Autowired
    public QuestionnaireRepository questionnaireRepository;

    Questionnaire questionnaire;

    Wizard wizard = new Wizard();

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

        final VerticalLayout root = new VerticalLayout(wizard);
        root.setSizeFull();
        root.setMargin(true);
        root.setSpacing(true);
        setContent(root);


    }

}
