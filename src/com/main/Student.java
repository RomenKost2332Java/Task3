package com.main;

public abstract class Student extends Person {
    @Override
    public String toString() {
        return "Student " + hashCode();
    }
}
