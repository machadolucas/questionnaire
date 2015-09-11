package me.machadolucas.questionnaire.entity;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

import org.springframework.data.annotation.Id;

@Data
public class Question {

    @Id
    private String id;

    private String title;

    private String description;

    private String image;

    private Map<Devices, Integer> devices;

    public Question() {
        devices = new HashMap<>();
        for (Devices device : Devices.values()) {
            devices.put(device, Integer.valueOf(0));
        }
    }

}