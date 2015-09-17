package me.machadolucas.questionnaire.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.HashMap;
import java.util.Map;

@Data
public class Question {

    @Id
    private String id;

    private String name;

    private Map<Devices, Integer> devices;

    public Question() {
        devices = new HashMap<>();
        for (Devices device : Devices.values()) {
            devices.put(device, Integer.valueOf(0));
        }
    }

}
