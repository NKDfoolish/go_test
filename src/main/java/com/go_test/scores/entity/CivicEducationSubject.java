package com.go_test.scores.entity;

public class CivicEducationSubject extends Subject {
    public CivicEducationSubject() {
            super("gdcd");
        }

        @Override
        public boolean isMandatory() {
            return false;
        }
    }