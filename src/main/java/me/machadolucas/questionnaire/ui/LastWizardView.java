package me.machadolucas.questionnaire.ui;

import com.vaadin.event.Transferable;
import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.event.dd.DropHandler;
import com.vaadin.event.dd.DropTarget;
import com.vaadin.event.dd.TargetDetails;
import com.vaadin.event.dd.acceptcriteria.AcceptCriterion;
import com.vaadin.event.dd.acceptcriteria.Not;
import com.vaadin.event.dd.acceptcriteria.SourceIsTarget;
import com.vaadin.shared.ui.dd.HorizontalDropLocation;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import lombok.Getter;
import me.machadolucas.questionnaire.helper.DevicesComponentsCreator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LastWizardView extends WizardViews {

    Label pageTitle = new Label("Concluindo...");

    @Getter
    TextArea moreInformation = new TextArea("Há mais alguma informação sobre suas experiências que você gostaria que fosse considerada? (Opcional)");

    @Getter
    SortableLayout sorter = new SortableLayout(false);

    public LastWizardView() {
        configureComponents();
        buildLayout();
    }

    void configureComponents() {

        sorter.setSizeUndefined();
        sorter.setWidth("150px");
        sorter.addStyleName("no-horizontal-drag-hints");
        sorter.setCaption("Segundo sua experiência no jogo Fruit Ninja, ordene os dispositivos do melhor ao pior");
        List<Button> devices = DevicesComponentsCreator.createDevicesLabels();
        devices.forEach(sorter::addComponent);

        moreInformation.setRows(5);
        moreInformation.setWordwrap(true);
        moreInformation.setWidth("500px");
    }

    void buildLayout() {
        setMargin(true);
        setSpacing(true);

        Label gap = new Label();
        gap.setHeight("2em");

        pageTitle.setStyleName(ValoTheme.LABEL_H1);

        addComponents(pageTitle, sorter, gap, moreInformation);
    }

    public static class SortableLayout extends CustomComponent {
        private final AbstractOrderedLayout layout;
        private final boolean horizontal;
        private final ReorderLayoutDropHandler dropHandler;

        public SortableLayout(boolean horizontal) {
            this.horizontal = horizontal;
            if (horizontal) {
                layout = new HorizontalLayout();
            } else {
                layout = new VerticalLayout();
            }
            dropHandler = new ReorderLayoutDropHandler(layout);

            DragAndDropWrapper pane = new DragAndDropWrapper(layout);
            setCompositionRoot(pane);
        }

        public void addComponent(Component component) {
            WrappedComponent wrapper = new WrappedComponent(component,
                    dropHandler);
            wrapper.setSizeUndefined();
            if (horizontal) {
                component.setHeight("100%");
                wrapper.setHeight("100%");
            } else {
                component.setWidth("100%");
                wrapper.setWidth("100%");
            }
            layout.addComponent(wrapper);
        }

        public List<Component> getComponentsList() {
            List<WrappedComponent> wrappedComponents = new LinkedList<>();
            this.dropHandler.getComponents().forEachRemaining((e) -> wrappedComponents.add((WrappedComponent) e));
            List<Component> components = new LinkedList<>();
            wrappedComponents.forEach((e) -> components.add(e.getComponentElement()));
            return components;
        }
    }

    private static class WrappedComponent extends DragAndDropWrapper {

        private final DropHandler dropHandler;
        private final Component componentElement;

        public WrappedComponent(Component content, DropHandler dropHandler) {
            super(content);
            this.componentElement = content;
            this.dropHandler = dropHandler;
            setDragStartMode(DragStartMode.WRAPPER);
        }

        @Override
        public DropHandler getDropHandler() {
            return dropHandler;
        }

        public Component getComponentElement() {
            return this.componentElement;
        }

    }

    private static class ReorderLayoutDropHandler implements DropHandler {

        private AbstractOrderedLayout layout;

        public ReorderLayoutDropHandler(AbstractOrderedLayout layout) {
            this.layout = layout;
        }

        public AcceptCriterion getAcceptCriterion() {
            return new Not(SourceIsTarget.get());
        }

        public Iterator<Component> getComponents() {
            return layout.iterator();
        }

        public void drop(DragAndDropEvent dropEvent) {
            Transferable transferable = dropEvent.getTransferable();
            Component sourceComponent = transferable.getSourceComponent();
            if (sourceComponent instanceof WrappedComponent) {
                TargetDetails dropTargetData = dropEvent.getTargetDetails();
                DropTarget target = dropTargetData.getTarget();

                // find the location where to move the dragged component
                boolean sourceWasAfterTarget = true;
                int index = 0;
                Iterator<Component> componentIterator = layout
                        .getComponentIterator();
                Component next = null;
                while (next != target && componentIterator.hasNext()) {
                    next = componentIterator.next();
                    if (next != sourceComponent) {
                        index++;
                    } else {
                        sourceWasAfterTarget = false;
                    }
                }
                if (next == null || next != target) {
                    // component not found - if dragging from another layout
                    return;
                }

                // drop on top of target?
                if (dropTargetData.getData("horizontalLocation").equals(
                        HorizontalDropLocation.CENTER.toString())) {
                    if (sourceWasAfterTarget) {
                        index--;
                    }
                }

                // drop before the target?
                else if (dropTargetData.getData("horizontalLocation").equals(
                        HorizontalDropLocation.LEFT.toString())) {
                    index--;
                    if (index < 0) {
                        index = 0;
                    }
                }

                // move component within the layout
                layout.removeComponent(sourceComponent);
                layout.addComponent(sourceComponent, index);
            }
        }
    }

    ;
}
