package com.main;

import exceptions.NotEnoughGroupsException;
import exceptions.NotEnoughStudentsException;
import exceptions.NotEnoughTeachersException;
import exceptions.TooManyStudentsException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public abstract class Department {
    public static final int minGroupsAmount = 1;
    public static final int minTeachersAmount = 3;

    private HashSet<Group> groups = new HashSet<>();
    private HashSet<Teacher> teachers = new HashSet<>();

    public void addGroup(Group group) throws NotEnoughStudentsException {
        if (group.studentsAmount() < Group.minStudentAmount)
            throw new NotEnoughStudentsException();
        groups.add(group);
    }

    public void addGroups(Collection<Group> groups) throws NotEnoughStudentsException {
        for (Group group : groups)
            addGroup(group);
    }

    public void removeGroup(Group group) throws NotEnoughGroupsException {
        if (groups.size() == minGroupsAmount && groups.contains(group))
            throw new NotEnoughGroupsException();
        groups.remove(group);
    }

    public void removeGroups(Collection<Group> groups) throws NotEnoughGroupsException {
        HashSet<Group> backUp = (HashSet<Group>) Set.copyOf(this.groups);
        this.groups.removeAll(groups);
        if (this.groups.size() < minGroupsAmount) {
            this.groups = backUp;
            throw new NotEnoughGroupsException();
        }
    }

    public void addTeacher(Teacher teacher) { teachers.add(teacher); }
    public void addTeachers(Collection<Teacher> teachers) { this.teachers.addAll(teachers); }

    public void removeTeacher(Teacher teacher) throws NotEnoughTeachersException {
        if (teachers.size() == minTeachersAmount && teachers.contains(teacher))
            throw new NotEnoughTeachersException();
        teachers.remove(teacher);
    }

    public void removeTeachers(Collection<Teacher> teachers) throws NotEnoughTeachersException {
        HashSet<Teacher> backUp = (HashSet<Teacher>) Set.copyOf(this.teachers);
        this.teachers.removeAll(teachers);
        if (groups.size() < minGroupsAmount) {
            this.teachers = backUp;
            throw new NotEnoughTeachersException();
        }
    }

    public Set<Group> getGroups() { return Set.copyOf(groups); }
    public Set<Teacher> getTeachers() { return Set.copyOf(teachers); }

    public int groupsAmount() { return groups.size(); }
    public int teachersAmount() { return teachers.size(); }
}