package com.go_test.scores.entity;

public class ChemistrySubject extends Subject {
    public ChemistrySubject() {
        super("hoa_hoc");
    }

    @Override
    public boolean isMandatory() {
        return true; // Mandatory for group A
    }
}
