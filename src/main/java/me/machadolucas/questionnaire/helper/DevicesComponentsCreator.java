package me.machadolucas.questionnaire.helper;

import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;
import me.machadolucas.questionnaire.entity.Devices;

import java.util.LinkedList;
import java.util.List;

public class DevicesComponentsCreator {

    public static List<Button> createDevicesLabels() {
        List<Button> devices = new LinkedList<>();

        for (Devices device : Devices.values()) {
            Button component = new Button(device.getName());
            component.setStyleName(ValoTheme.BUTTON_LARGE);
            devices.add(component);
        }

        return devices;
    }
}
