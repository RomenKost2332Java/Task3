package com.main;

/**
 * The class to containing and processing an information about a student.
 * @author Kostenko Roman
 */
public abstract class Student extends Person {
    @Override
    public String toString() {
        return "Student " + hashCode();
    }
}
