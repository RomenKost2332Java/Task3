package com.main;

/**
 * The class to containing and processing an information about a subject.
 * @author Kostenko Roman
 */
public abstract class Subject {
    @Override
    public String toString() {
        return "Subject " + hashCode();
    }
}
