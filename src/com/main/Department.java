package com.main;

import exceptions.NotEnoughGroupsException;
import exceptions.NotEnoughStudentsException;
import exceptions.NotEnoughTeachersException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public abstract class Department {
    public static final int minGroupsAmount = 1;
    public static final int minTeachersAmount = 3;

    private HashSet<Group> groups = new HashSet<>();
    private HashSet<Teacher> teachers = new HashSet<>();

    Department(){}
    Department(Collection<Group> groups) throws NotEnoughStudentsException { addGroups(groups); }
    Department(Collection<Group> groups, Collection<Teacher> teachers) throws NotEnoughStudentsException {
        addGroups(groups);
        addTeachers(teachers);
    }

    public void addGroup(Group group) throws NotEnoughStudentsException {
        if (group.studentsAmount() < Group.minStudentAmount){
            throw new NotEnoughStudentsException();
        }
        groups.add(group);
    }

    public void addGroups(Collection<Group> groups) throws NotEnoughStudentsException {
        for (Group group : groups){
            addGroup(group);
        }
    }

    public void removeGroup(Group group) throws NotEnoughGroupsException {
        if (groups.size() == minGroupsAmount && groups.contains(group)){
            throw new NotEnoughGroupsException();
        }
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
        if (teachers.size() == minTeachersAmount && teachers.contains(teacher)){
            throw new NotEnoughTeachersException();
        }
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Department department = (Department) obj;

        return groups.equals(department.groups) && teachers.equals(department.teachers);
    }

    @Override
    public int hashCode() {
        return groups.size() + 31 * teachers.size();
    }
}