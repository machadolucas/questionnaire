package me.machadolucas.questionnaire.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Devices {

    MOUSE("Mouse"), GAMEPAD("Gamepad"), TOUCH("Toque"), KINECT("Kinect");

    @Getter
    private String name;

}
