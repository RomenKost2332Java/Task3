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
    Group(int specializationCode, Curator curator, Collection<Student> students) throws TooManyStudentsException {
        this(specializationCode, curator);
        addStudents(students);
    }
    Group(int specializationCode, Curator curator, Collection<Student> students, Collection<Subject> subjects) throws TooManyStudentsException {
        this(specializationCode, curator, students);
        addSubjects(subjects);
    }

    public Curator getCurator() { return curator; }
    public int getSpecializationCode() { return specializationCode; }
    public Set<Subject> getSubjects() { return Set.copyOf(subjects); }
    public Set<Student> getStudents() { return Set.copyOf(students); }

    public void addSubject(Subject subject) { subjects.add(subject); }
    public void addSubjects(Collection<Subject> subjects) { this.subjects.addAll(subjects); }

    public void removeSubject(Subject subject){ subjects.remove(subject); }
    public void removeSubjects(Collection<Subject> subjects){ this.subjects.removeAll(subjects); }

    public void addStudent(Student student) throws TooManyStudentsException {
        if (students.size() == maxStudentAmount && !students.contains(student)){
            throw new TooManyStudentsException();
        }
        students.add(student);
    }

    public void addStudents(Collection<Student> students) throws TooManyStudentsException {
        HashSet<Student> backUp = (HashSet<Student>) Set.copyOf(this.students);
        this.students.addAll(students);
        if (this.students.size() > maxStudentAmount) {
            this.students = backUp;
            throw new TooManyStudentsException();
        }
    }

    public void removeStudent(Student student) throws NotEnoughStudentsException {
        if (students.size() == minStudentAmount && students.contains(student)){
            throw new NotEnoughStudentsException();
        }
        students.remove(student);
    }

    public void removeStudents(Collection<Student> students) throws NotEnoughStudentsException {
        HashSet<Student> backUp = (HashSet<Student>) Set.copyOf(this.students);
        this.students.addAll(students);
        if (this.students.size() < minStudentAmount) {
            this.students = backUp;
            throw new NotEnoughStudentsException();
        }
    }

    public void setCurator(Curator curator){ this.curator = curator; }
    public int studentsAmount(){ return students.size(); }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Group group = (Group) obj;

        return students.equals(group.students) && subjects.equals(group.subjects) && curator.equals(group.curator);
    }

    @Override
    public int hashCode() {
        return 1000*(students.size() + (maxStudentAmount + 1)*subjects.size()) + specializationCode;
    }
}
