package com.main;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public abstract class Teacher extends Person {
    private HashSet<Subject> subjects = new HashSet<>();

    public Teacher() {}
    public Teacher(Subject subject){ addSubject(subject);}
    public Teacher(Collection<Subject> subjects) {addSubjects(subjects);}

    public Set<Subject> getSubjects() { return Set.copyOf(subjects); }

    public void addSubject(Subject subject) { subjects.add(subject); }
    public void addSubjects(Collection<Subject> subjects) { this.subjects.addAll(subjects); }

    public void removeSubject(Subject subject) { subjects.remove(subject); }
    public void removeSubjects(Collection<Subject> subjects) { this.subjects.removeAll(subjects); }

    @Override
    public String toString() {
        return "Teacher. " + subjects.size() + " subjects.";
    }
}
