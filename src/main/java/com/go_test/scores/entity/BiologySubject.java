package com.go_test.scores.entity;

public class BiologySubject extends Subject {
    public BiologySubject() {
        super("sinh_hoc");
    }

    @Override
    public boolean isMandatory() {
        return false;
    }
}