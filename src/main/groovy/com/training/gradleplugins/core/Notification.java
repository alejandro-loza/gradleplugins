package com.training.gradleplugins.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.training.gradleplugins.deserializers.HelloDeserializer;
import com.yammer.dropwizard.json.JsonSnakeCase;


@JsonDeserialize(using=HelloDeserializer.class)
@JsonSnakeCase
public class Notification {
    private final String text;

    @JsonCreator
    public Notification(@JsonProperty("text") String text) {
        this.text = text;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }
}