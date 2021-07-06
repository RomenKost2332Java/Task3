package com.main;

import exceptions.NotEnoughStudentsException;
import exceptions.TooManyStudentsException;

import java.util.*;

public abstract class Group {
    public static final int minStudentAmount = 6;
    public static final int maxStudentAmount = 30;

    private int specializationCode;
    private Curator curator;

    private HashSet<Subject> subjects = new HashSet<>();
    private HashSet<Student> students = new HashSet<>();

    Group(int specializationCode, Curator curator) {
        this.specializationCode = specializationCode;
        this.curator = curator;
    }

    public int getSpecializationCode() {
        return specializationCode;
    }

    public Set<Subject> getSubjects() {
        return Set.copyOf(subjects);
    }

    public Set<Student> getStudents() {
        return Set.copyOf(students);
    }

    public Curator getCurator() {
        return curator;
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public void addSubjects(Collection<Subject> subjects) {
        this.subjects.addAll(subjects);
    }

    public void addStudent(Student student) throws TooManyStudentsException {
        if (students.size() == maxStudentAmount)
            throw new TooManyStudentsException();
        students.add(student);
    }

    public void addStudents(Collection<Student> students) throws NotEnoughStudentsException {
        if (this.students.size() + students.size() > maxStudentAmount)
            throw new NotEnoughStudentsException();
        this.students.addAll(students);
    }

    public void setCurator(Curator curator){
        this.curator = curator;
    }

    public int studentsAmount(){
        return students.size();
    }
}
