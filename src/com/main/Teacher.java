package com.main;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * The class to containing and processing an information about a teacher (Contains and processes subjects).
 * @author Kostenko Roman
 */
public abstract class Teacher extends Person {
    /**
     * The subjects container.
     */
    private HashSet<Subject> subjects = new HashSet<>();

    /**
     * An empty constructor.
     */
    public Teacher() {}

    /**
     * This constructor adds subject to the subjects container during creating object of this class.
     * @param subject - a subject to adding to the subjects container.
     */
    public Teacher(Subject subject){ addSubject(subject);}

    /**
     * This constructor adds subjects from the collection to the subjects container during creating object of this
     * class.
     * @param subjects - a collection of subjects to adding to the subjects container.
     */
    public Teacher(Collection<Subject> subjects) {addSubjects(subjects);}

    /**
     * The getter of the subjects container.
     * @return a copy of the container of subjects.
     */
    public Set<Subject> getSubjects() { return Set.copyOf(subjects); }

    /**
     * The setter of the subjects container.
     * @param subjects - a collection of subjects to setting to the subjects container.
     */
    public void setSubjects(Collection<Subject> subjects){
        this.subjects = new HashSet<>();
        addSubjects(subjects);
    }

    /**
     * This method adds the subject to the subjects container.
     * @param subject - the subject to adding to the subjects collection.
     */
    public void addSubject(Subject subject) { subjects.add(subject); }

    /**
     * This method adds the all subjects from the collection to the subjects container.
     * @param subjects - the subjects collection to adding to the subjects container.
     */
    public void addSubjects(Collection<Subject> subjects) { this.subjects.addAll(subjects); }

    /**
     * This method removes the subject from the subjects container.
     * @param subject - the subject to removing from the subjects container.
     */
    public void removeSubject(Subject subject) { subjects.remove(subject); }

    /**
     * This method removes from the subjects container the all subjects from the subjects collection.
     * @param subjects - the collection of subjects to removing from the subjects container.
     */
    public void removeSubjects(Collection<Subject> subjects) { this.subjects.removeAll(subjects); }

    /**
     * This method finds amount of subjects in the subjects container.
     * @return a size of the subjects container.
     */
    public int subjectsAmount(){ return subjects.size(); }

    @Override
    public String toString() {
        return "Teacher. " + subjects.size() + " subjects.";
    }
}
