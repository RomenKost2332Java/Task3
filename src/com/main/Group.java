package com.main;

import exceptions.NoCuratorException;
import exceptions.NotEnoughStudentsException;
import exceptions.TooManyStudentsException;
import exceptions.WrongStudentsAmountException;

import java.util.*;

public abstract class Group {
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
    private HashSet<Subject> subjects = new HashSet<>();

    /**
     * The students container.
     */
    private HashSet<Student> students = new HashSet<>();

    /**
     * This constructor sets the specialization code of this group.
     * @param specializationCode - the specialization code of the group.
     */
    public Group(int specializationCode) {
        this.specializationCode = specializationCode;
    }

    /**
     * This constructor sets the specialization code and curator of this group.
     * @param specializationCode - the specialization code of the group.
     * @param curator - the curator of this group.
     * @throws NoCuratorException - the curator of this group can't be null.
     */
    public Group(int specializationCode, Curator curator) throws NoCuratorException {
        this(specializationCode);
        setCurator(curator);
    }

    /**
     * This constructor sets the specialization code and curator of this group, sets students from the students
     * collection to the students container during creating object of this class.
     * @param specializationCode - the specialization code of the group.
     * @param curator - the curator of this group.
     * @param students - a collection of students to setting to the students container.
     * @throws WrongStudentsAmountException if a department that have wrong students amount exists in the collection.
     * @throws NoCuratorException - the curator of this group can't be null.
     */
    public Group(int specializationCode, Curator curator, Collection<Student> students) throws WrongStudentsAmountException, NoCuratorException {
        this(specializationCode, curator);
        setStudents(students);
    }

    /**
     * This constructor sets the specialization code and curator of this group, sets students from the students
     * collection to the students container and sets subjects from the subjects collection to the subjects container
     * during creating object of this class.
     * @param specializationCode - the specialization code of the group.
     * @param curator - the curator of this group.
     * @param students - a collection of students to setting to the students container.
     * @param subjects - a collection of students to setting to the students container.
     * @throws WrongStudentsAmountException if a department that have wrong students amount exists in the collection.
     * @throws NoCuratorException - the curator of this group can't be null.
     */
    public Group(int specializationCode, Curator curator, Collection<Student> students, Collection<Subject> subjects) throws WrongStudentsAmountException, NoCuratorException {
        this(specializationCode, curator, students);
        addSubjects(subjects);
    }

    /**
     *
     * @return
     */
    public Curator getCurator() { return curator; }
    public int getSpecializationCode() { return specializationCode; }

    /**
     * The getter of the subjects container.
     * @return a copy of the container of subjects.
     */
    public Set<Subject> getSubjects() { return Set.copyOf(subjects); }
    public Set<Student> getStudents() { return Set.copyOf(students); }

    public void setCurator(Curator curator) throws NoCuratorException {
        if (curator == null){
            throw new NoCuratorException();
        }
        this.curator = curator;
    }

    public void setSubjects(Collection<Subject> subjects){
        this.subjects = new HashSet<>();
        addSubjects(subjects);
    }

    public void setStudents(Collection<Student> students) throws WrongStudentsAmountException {
        HashSet<Student> backUp = (HashSet<Student>) Set.copyOf(this.students);
        this.students = new HashSet<>();
        try {
            addStudents(students);
            if (students.size() < MIN_STUDENT_AMOUNT){
                throw new NotEnoughStudentsException();
            }
        }
        catch (WrongStudentsAmountException e) {
            this.students = backUp;
            throw e;
        }
    }

    public void addSubject(Subject subject) { subjects.add(subject); }
    public void addSubjects(Collection<Subject> subjects) { this.subjects.addAll(subjects); }

    public void removeSubject(Subject subject){ subjects.remove(subject); }
    public void removeSubjects(Collection<Subject> subjects){ this.subjects.removeAll(subjects); }

    public void addStudent(Student student) throws TooManyStudentsException {
        if (students.size() == MAX_STUDENT_AMOUNT && !students.contains(student)){
            throw new TooManyStudentsException();
        }
        students.add(student);
    }

    public void addStudents(Collection<Student> students) throws TooManyStudentsException {
        HashSet<Student> backUp = (HashSet<Student>) Set.copyOf(this.students);
        this.students.addAll(students);
        if (this.students.size() > MAX_STUDENT_AMOUNT) {
            this.students = backUp;
            throw new TooManyStudentsException();
        }
    }

    public void removeStudent(Student student) throws NotEnoughStudentsException {
        if (students.size() == MIN_STUDENT_AMOUNT && students.contains(student)){
            throw new NotEnoughStudentsException();
        }
        students.remove(student);
    }

    public void removeStudents(Collection<Student> students) throws NotEnoughStudentsException {
        HashSet<Student> backUp = (HashSet<Student>) Set.copyOf(this.students);
        this.students.addAll(students);
        if (this.students.size() < MIN_STUDENT_AMOUNT) {
            this.students = backUp;
            throw new NotEnoughStudentsException();
        }
    }

    public int studentsAmount(){ return students.size(); }
    public int subjectsAmount(){ return subjects.size(); }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Group group = (Group) obj;

        return specializationCode == group.specializationCode &&
                students.equals(group.students) &&
                subjects.equals(group.subjects) &&
                curator.equals(group.curator);
    }

    @Override
    public int hashCode() {
        return 1000*(students.size() + (MAX_STUDENT_AMOUNT + 1)*subjects.size()) + specializationCode;
    }

    @Override
    public String toString() {
        return "Group " + specializationCode + ". " + students.size() + " students. " + subjects.size() + " subject.";
    }
}
