package me.machadolucas.questionnaire.ui;

import com.vaadin.ui.VerticalLayout;

/**
 * Created by machadolucas on 16/09/15.
 */
public abstract class WizardViews extends VerticalLayout {

    abstract void configureComponents();

    abstract void buildLayout();

}
