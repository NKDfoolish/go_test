package com.go_test.scores.entity;

public class MathSubject extends Subject {
    public MathSubject() {
        super("toan");
    }

    @Override
    public boolean isMandatory() {
        return true;
    }
}
