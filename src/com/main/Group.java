package com.main;

import exceptions.NoCuratorException;
import exceptions.NotEnoughStudentsException;
import exceptions.TooManyStudentsException;
import exceptions.WrongStudentsAmountException;

import java.util.*;

public class Group {
    /**
     * Min amount students that may contain group in a department.
     */
    public static final int MIN_STUDENT_AMOUNT = 6;

    /**
     * Max amount students that may contain group in a department.
     */
    public static final int MAX_STUDENT_AMOUNT = 30;

    /**
     * The specialization code of the group. The group object cannot change its specialization.
     */
    private final int specializationCode;

    /**
     * The curator of the group. The curator must be chosen when group be added in the department.
     */
    private Curator curator;

    /**
     * The subjects container.
     */
    private Set<Subject> subjects = new HashSet<>();

    /**
     * The students container.
     */
    private Set<Student> students = new HashSet<>();

    /**
     * This constructor sets the specialization code and curator of this group, sets students from the students set to
     * the students container and sets subjects from the subjects set to the subjects container during creating object
     * of this class.
     *
     * @param specializationCode - the specialization code of the group.
     * @param curator            - the curator of this group.
     * @param students           - a set of students to setting to the students container.
     * @param subjects           - a set of students to setting to the students container.
     * @throws WrongStudentsAmountException if a department that have wrong students amount exists in the set.
     * @throws NoCuratorException           - the curator of this group can't be null.
     */
    public Group(int specializationCode, Curator curator, Set<Student> students, Set<Subject> subjects) throws WrongStudentsAmountException, NoCuratorException {
        this.specializationCode = specializationCode;
        setCurator(curator);
        setStudents(students);
        setSubjects(subjects);
    }

    /**
     * The getter of the curator variable.
     *
     * @return curator object.
     */
    public Curator getCurator() {
        return curator;
    }

    /**
     * The getter of the specializationCode variable.
     *
     * @return specialization code of the group.
     */
    public int getSpecializationCode() {
        return specializationCode;
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
     * The getter of the students container.
     *
     * @return a copy of the container of subjects.
     */
    public Set<Student> getStudents() {
        return Set.copyOf(students);
    }

    /**
     * The setter of the curator variable.
     *
     * @param curator - the curator to setting in variable.
     * @throws NoCuratorException if curator is null.
     */
    public void setCurator(Curator curator) throws NoCuratorException {
        if (curator == null) {
            throw new NoCuratorException();
        }
        this.curator = curator;
    }

    /**
     * The setter of the subjects container.
     *
     * @param subjects - a set of subjects to adding to the subjects container.
     */
    public void setSubjects(Set<Subject> subjects) {
        this.subjects = new HashSet<>(subjects);
    }

    /**
     * The setter of the subjects container.
     *
     * @param students - a set of students to adding to the students container.
     * @throws NotEnoughStudentsException - if the students container won't have enough students after setting.
     * @throws TooManyStudentsException   - if the students container will have too many students after setting.
     */
    public void setStudents(Set<Student> students) throws WrongStudentsAmountException {
        if (students.size() < MIN_STUDENT_AMOUNT) {
            throw new NotEnoughStudentsException();
        }
        if (students.size() > MAX_STUDENT_AMOUNT) {
            throw new TooManyStudentsException();
        }
        this.students = new HashSet<>(students);
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
     * This method adds the all subjects from the collection to the subjects container.
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
     * This method adds the student to the student container.
     *
     * @param student - the student to adding to the students container.
     * @throws TooManyStudentsException if the group have too many students.
     */
    public void addStudent(Student student) throws TooManyStudentsException {
        if (students.size() == MAX_STUDENT_AMOUNT && !students.contains(student)) {
            throw new TooManyStudentsException();
        }
        students.add(student);
    }

    /**
     * This method adds the all students from the set to the students container.
     *
     * @param students - the students set to adding to the students container.
     * @throws TooManyStudentsException if the group will have to many students after adding.
     */
    public void addStudents(Collection<Student> students) throws TooManyStudentsException {
        HashSet<Student> backUp = (HashSet<Student>) Set.copyOf(this.students);
        this.students.addAll(students);
        if (this.students.size() > MAX_STUDENT_AMOUNT) {
            this.students = backUp;
            throw new TooManyStudentsException();
        }
    }

    /**
     * This method removes the student from the students container.
     *
     * @param student - the student to removing from the students container.
     * @throws NotEnoughStudentsException if the students container won't have enough students after removing.
     */
    public void removeStudent(Student student) throws NotEnoughStudentsException {
        if (students.size() == MIN_STUDENT_AMOUNT && students.contains(student)) {
            throw new NotEnoughStudentsException();
        }
        students.remove(student);
    }

    /**
     * This method removes from the students container the all students from the students set.
     *
     * @param students - the set of students to removing from the students container.
     * @throws NotEnoughStudentsException if the students container won't have enough students after removing.
     */
    public void removeStudents(Set<Student> students) throws NotEnoughStudentsException {
        Set<Student> backUp = Set.copyOf(this.students);
        this.students.addAll(students);
        if (this.students.size() < MIN_STUDENT_AMOUNT) {
            this.students = backUp;
            throw new NotEnoughStudentsException();
        }
    }

    /**
     * This method finds amount of students in the students container.
     *
     * @return a size of the students container.
     */
    public int studentsAmount() {
        return students.size();
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
        Group group = (Group) o;
        return specializationCode == group.specializationCode &&
                Objects.equals(curator, group.curator) &&
                Objects.equals(subjects, group.subjects) &&
                Objects.equals(students, group.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(specializationCode, curator, subjects, students);
    }

    @Override
    public String toString() {
        return "Group{" +
                "specializationCode=" + specializationCode +
                ", curator=" + curator +
                ", subjects=" + subjects +
                ", students=" + students +
                '}';
    }

}
