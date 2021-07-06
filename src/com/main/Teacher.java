package com.main;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public abstract class Teacher extends Person {
    private HashSet<Subject> subjects = new HashSet<>();

    public Set<Subject> getSubjects() {
        return Set.copyOf(subjects);
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public void addSubjects(Collection<Subject> subjects) {
        this.subjects.addAll(subjects);
    }
}
