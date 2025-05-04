package com.go_test.scores.entity;

public class LiteratureSubject extends Subject {
    public LiteratureSubject() {
        super("ngu_van");
    }

    @Override
    public boolean isMandatory() {
        return false; // Not mandatory for group A
    }
}
