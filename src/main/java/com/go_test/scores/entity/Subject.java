package com.go_test.scores.entity;

public abstract class Subject {
    protected String name;

    public Subject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract boolean isMandatory();
}
