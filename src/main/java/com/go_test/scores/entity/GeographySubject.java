package com.go_test.scores.entity;

public class GeographySubject extends Subject {
    public GeographySubject() {
        super("dia_li");
    }

    @Override
    public boolean isMandatory() {
        return false;
    }
}
