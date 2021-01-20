package com.simpleexample.kafka_producer2;

import java.io.Serializable;

public class MoreSimpleModel implements Serializable {

    private String title;
    private String description;

    public MoreSimpleModel(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public MoreSimpleModel(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return title + " " + description + "\n";
    }
}
