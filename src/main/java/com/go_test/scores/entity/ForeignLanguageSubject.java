package com.go_test.scores.entity;

public class ForeignLanguageSubject extends Subject {
    public ForeignLanguageSubject() {
        super("ngoai_ngu");
    }

    @Override
    public boolean isMandatory() {
        return false;
    }
}
