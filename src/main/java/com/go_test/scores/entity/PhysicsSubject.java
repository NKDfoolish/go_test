package com.go_test.scores.entity;

public class PhysicsSubject extends Subject {
    public PhysicsSubject() {
        super("vat_li");
    }

    @Override
    public boolean isMandatory() {
        return true; // Mandatory for group A
    }
}
