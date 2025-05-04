package com.go_test.scores.entity;

public class HistorySubject extends Subject {
    public HistorySubject() {
        super("lich_su");
    }

    @Override
    public boolean isMandatory() {
        return false;
    }
}
