package com.main;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The class to containing and processing an information about an university (Contain and process faculties and
 * subjects).
 *
 * @author Kostenko Roman
 */
public class University {
    /**
     * The faculties container.
     */
    private Set<Faculty> faculties = new HashSet<>();

    /**
     * The subjects container.
     */
    private Set<Subject> subjects = new HashSet<>();

    /**
     * An empty constructor.
     */
    public University() {

    }

    /**
     * This constructor adds faculty to the faculties container during creating object of this class.
     *
     * @param faculty - the faculty to setting to the faculties container.
     */
    public University(Faculty faculty) {
        faculties = new HashSet<>();
        faculties.add(faculty);
        setFaculties(faculties);
    }

    /**
     * This constructor sets subject to the subjects container during creating object of this class.
     *
     * @param subject - a subject to adding to the subjects container.
     */
    public University(Subject subject) {

    }

    /**
     * This constructor sets faculties from the set to the faculties container during creating object of this class.
     *
     * @param faculties - a set of faculties to setting to the faculties container.
     */
    public University(Set<Faculty> faculties) {
        setFaculties(faculties);
    }

    /**
     * This constructor sets faculties from the set to the faculties container and sets subject to the subjects
     * container during creating object of this class.
     *
     * @param faculties - a set of faculties to setting to the faculties container.
     */
    public University(Set<Faculty> faculties, Set<Subject> subjects) {
        setFaculties(faculties);
        setSubjects(subjects);
    }

    /**
     * The getter of the faculties container.
     *
     * @return a copy of the container of faculties.
     */
    public Set<Faculty> getFaculties() {
        return Set.copyOf(faculties);
    }

    /**
     * The setter of the faculties container.
     *
     * @param faculties - the set of faculties to setting to the faculties container.
     */
    public void setFaculties(Set<Faculty> faculties) {
        this.faculties = new HashSet<>(faculties);
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
     * @param subjects - the set of subjects to setting to the subjects container.
     */
    public void setSubjects(Set<Subject> subjects) {
        this.subjects = new HashSet<>(subjects);
    }

    /**
     * This method adds the faculty to the faculties container.
     *
     * @param faculty - the faculty to adding to the faculties container.
     */
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    /**
     * This method adds the all faculties from the set to the faculties container.
     *
     * @param faculties - the faculties set to adding to the faculties container.
     */
    public void addFaculties(Set<Faculty> faculties) {
        this.faculties.addAll(faculties);
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
     * This method removes the faculty from the faculties container.
     *
     * @param faculty - the faculty to removing from the faculties container.
     */
    public void removeFaculty(Faculty faculty) {
        faculties.remove(faculty);
    }

    /**
     * This method removes from the faculties container the all faculties from the faculties set.
     *
     * @param faculties - the set of faculties to removing from the faculties container.
     */
    public void removeFaculties(Set<Faculty> faculties) {
        this.faculties.removeAll(faculties);
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
     * This method finds amount of faculties in the faculties container.
     *
     * @return the size of the faculties container.
     */
    public int facultiesAmount() {
        return faculties.size();
    }

    /**
     * This method finds amount of subjects in the subjects container.
     *
     * @return the size of the subjects container.
     */
    public int subjectsAmount() {
        return subjects.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return Objects.equals(faculties, that.faculties) &&
                Objects.equals(subjects, that.subjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculties, subjects);
    }

    @Override
    public String toString() {
        return "University{" +
                "faculties=" + faculties +
                ", subjects=" + subjects +
                '}';
    }
}
