package com.main;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The class to containing and processing an information about a teacher (Contains and processes subjects).
 *
 * @author Kostenko Roman
 */
public class Teacher extends Person {
    /**
     * The subjects container.
     */
    private Set<Subject> subjects = new HashSet<>();

    /**
     * An empty constructor.
     */
    public Teacher() {
    }

    /**
     * This constructor adds subject to the subjects container during creating object of this class.
     *
     * @param subject - a subject to adding to the subjects container.
     */
    public Teacher(Subject subject) {
        addSubject(subject);
    }

    /**
     * This constructor adds subjects from the set to the subjects container during creating object of this
     * class.
     *
     * @param subjects - a set of subjects to setting to the subjects container.
     */
    public Teacher(Set<Subject> subjects) {
        setSubjects(subjects);
    }

    /**
     * The getter of the subjects container.
     *
     * @return a copy of the container of subjects.
     */
    public Set<Subject> getSubjects() {
        return Set.copyOf(subjects);
    }

    /**
     * The setter of the subjects container.
     *
     * @param subjects - a set of subjects to setting to the subjects container.
     */
    public void setSubjects(Set<Subject> subjects) {
        this.subjects = new HashSet<>(subjects);
    }

    /**
     * This method adds the subject to the subjects container.
     *
     * @param subject - the subject to adding to the subjects container.
     */
    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    /**
     * This method adds the all subjects from the set to the subjects container.
     *
     * @param subjects - the subjects set to adding to the subjects container.
     */
    public void addSubjects(Set<Subject> subjects) {
        this.subjects.addAll(subjects);
    }

    /**
     * This method removes the subject from the subjects container.
     *
     * @param subject - the subject to removing from the subjects container.
     */
    public void removeSubject(Subject subject) {
        subjects.remove(subject);
    }

    /**
     * This method removes from the subjects container the all subjects from the subjects set.
     *
     * @param subjects - the set of subjects to removing from the subjects container.
     */
    public void removeSubjects(Set<Subject> subjects) {
        this.subjects.removeAll(subjects);
    }

    /**
     * This method finds amount of subjects in the subjects container.
     *
     * @return a size of the subjects container.
     */
    public int subjectsAmount() {
        return subjects.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(subjects, teacher.subjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjects);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "subjects=" + subjects +
                '}';
    }
}
