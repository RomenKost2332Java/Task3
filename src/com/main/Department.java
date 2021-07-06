package com.main;

import exceptions.NotEnoughStudentsException;
import exceptions.TooManyStudentsException;
import exceptions.WrongStudentsAmountException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public abstract class Department {
    public static final int minGroupsAmount = 1;
    public static final int minTeachersAmount = 3;

    private HashSet<Group> groups = new HashSet<>();
    private HashSet<Teacher> teachers = new HashSet<>();

    public void addGroup(Group group) throws WrongStudentsAmountException {
        int studentAmount = group.studentsAmount();
        if (studentAmount < Group.minStudentAmount)
            throw new NotEnoughStudentsException();
        if (studentAmount > Group.maxStudentAmount)
            throw new TooManyStudentsException();
        groups.add(group);
    }

    public void addGroups(Collection<Group> groups) throws WrongStudentsAmountException {
        for (Group group : groups)
            addGroup(group);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void addTeachers(Collection<Teacher> teachers) {
        this.teachers.addAll(teachers);
    }

    public Set<Group> getGroups() {
        return Set.copyOf(groups);
    }

    public Set<Teacher> getTeachers() {
        return Set.copyOf(teachers);
    }

    public int groupsAmount() {
        return groups.size();
    }

    public int teachersAmount() {
        return teachers.size();
    }
}