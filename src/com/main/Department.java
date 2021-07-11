package com.main;

import exceptions.NoCuratorException;
import exceptions.NotEnoughGroupsException;
import exceptions.NotEnoughStudentsException;
import exceptions.NotEnoughTeachersException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public abstract class Department {
    /**
     * Min amount groups that may contain department in a faculty.
     */
    public static final int MIN_GROUPS_AMOUNT = 1;

    /**
     * Min amount teachers that may contain department in a faculty.
     */
    public static final int MIN_TEACHERS_AMOUNT = 3;

    /**
     * The groups container.
     */
    private HashSet<Group> groups = new HashSet<>();

    /**
     * The teachers container.
     */
    private HashSet<Teacher> teachers = new HashSet<>();

    /**
     * An empty constructor.
     */
    public Department(){}

    /**
     * This constructor adds groups from the collection to the groups container during creating object of this class.
     * @param groups - a collection of groups to setting to the groups container.
     * @throws NotEnoughStudentsException if a group that haven't enough students exists in the collection.
     * @throws NoCuratorException if a group that haven't curator exists in the collection.
     */
    public Department(Collection<Group> groups) throws NotEnoughStudentsException, NoCuratorException { addGroups(groups); }

    /**
     * This constructor adds groups from the groups collection to the groups container and teachers from the teachers
     * collection to the teachers container during creating object of this class.
     * @param groups - a collection of groups to setting to the groups container.
     * @param teachers - a collection of teachers to setting to the teachers container.
     * @throws NotEnoughStudentsException if a group that haven't enough students exists in the collection.
     * @throws NoCuratorException if a group that haven't curator exists in the collection.
     */
    public Department(Collection<Group> groups, Collection<Teacher> teachers) throws NotEnoughStudentsException, NoCuratorException {
        addGroups(groups);
        addTeachers(teachers);
    }

    /**
     * The getter of the groups container.
     * @return a copy of the container of groups.
     */
    public Set<Group> getGroups() { return Set.copyOf(groups); }

    /**
     * The getter of the teachers container.
     * @return a copy of the container of teachers.
     */
    public Set<Teacher> getTeachers() { return Set.copyOf(teachers); }

    /**
     * The setter of the groups container.
     * @param groups - a collection of groups to adding to the groups container.
     * @throws NotEnoughStudentsException if a group that haven't enough students exists in the collection.
     * @throws NoCuratorException if a group that haven't curator exists in the collection.
     */
    public void setGroups(Collection<Group> groups) throws NotEnoughStudentsException, NoCuratorException {
        HashSet<Group> backUp = (HashSet<Group>) Set.copyOf(this.groups);
        this.groups = new HashSet<>();
        try {
            addGroups(groups);
        }
        catch (NotEnoughStudentsException | NoCuratorException e) {
            this.groups = backUp;
            throw e;
        }
    }

    /**
     * The setter of the teachers container.
     * @param teachers - a collection of teachers to adding to the teachers container.
     */
    public void setTeachers(Collection<Teacher> teachers) {
        this.teachers = new HashSet<>();
        addTeachers(teachers);
    }

    /**
     * This method adds the group to the groups container.
     * @param group - the department to adding to the groups collection.
     * @throws NotEnoughStudentsException if the group haven't enough students.
     * @throws NoCuratorException if the group haven't a curator.
     */
    public void addGroup(Group group) throws NotEnoughStudentsException, NoCuratorException {
        if (group.studentsAmount() < Group.MIN_STUDENT_AMOUNT){
            throw new NotEnoughStudentsException();
        }
        if (group.getCurator() == null){
            throw new NoCuratorException();
        }
        groups.add(group);
    }

    /**
     * This method adds the all departments from the collection to the departments container.
     * @param groups - the groups collection to adding to the groups container.
     * @throws NotEnoughStudentsException if a group that haven't enough students exists in the collection.
     * @throws NoCuratorException if a group that haven't curator exists in the collection.
     */
    public void addGroups(Collection<Group> groups) throws NotEnoughStudentsException, NoCuratorException {
        for (Group group : groups){
            addGroup(group);
        }
    }

    /**
     * This method removes the group from the groups container.
     * @param group - the group to removing from the groups container.
     * @throws NotEnoughGroupsException if the groups container won't have enough groups after removing.
     */
    public void removeGroup(Group group) throws NotEnoughGroupsException {
        if (groups.size() == MIN_GROUPS_AMOUNT && groups.contains(group)){
            throw new NotEnoughGroupsException();
        }
        groups.remove(group);
    }

    /**
     * This method removes from the groups container the all groups from the groups collection.
     * @param groups - the collection of groups to removing from the groups container.
     * @throws NotEnoughGroupsException if the groups container won't have enough groups after removing.
     */
    public void removeGroups(Collection<Group> groups) throws NotEnoughGroupsException {
        HashSet<Group> backUp = (HashSet<Group>) Set.copyOf(this.groups);
        this.groups.removeAll(groups);
        if (this.groups.size() < MIN_GROUPS_AMOUNT) {
            this.groups = backUp;
            throw new NotEnoughGroupsException();
        }
    }

    /**
     * This method adds the teacher to the teachers container.
     * @param teacher - the teacher to adding to the teachers collection.
     */
    public void addTeacher(Teacher teacher) { teachers.add(teacher); }

    /**
     * This method adds the all teachers from the collection to the teachers container.
     * @param teachers - the teachers collection to adding to the teachers container.
     */
    public void addTeachers(Collection<Teacher> teachers) { this.teachers.addAll(teachers); }

    /**
     * This method removes the teacher from the teachers container.
     * @param teacher - the teacher to removing from the teachers container.
     * @throws NotEnoughTeachersException if the teachers container won't have enough teachers after removing.
     */
    public void removeTeacher(Teacher teacher) throws NotEnoughTeachersException {
        if (teachers.size() == MIN_TEACHERS_AMOUNT && teachers.contains(teacher)){
            throw new NotEnoughTeachersException();
        }
        teachers.remove(teacher);
    }

    /**
     * This method removes from the teachers container the all teachers from the teachers collection.
     * @param teachers - the collection of teachers to removing from the teachers container.
     * @throws NotEnoughTeachersException if the teachers container won't have enough teachers after removing.
     */
    public void removeTeachers(Collection<Teacher> teachers) throws NotEnoughTeachersException {
        HashSet<Teacher> backUp = (HashSet<Teacher>) Set.copyOf(this.teachers);
        this.teachers.removeAll(teachers);
        if (groups.size() < MIN_GROUPS_AMOUNT) {
            this.teachers = backUp;
            throw new NotEnoughTeachersException();
        }
    }

    /**
     * This method finds amount of groups in the groups container.
     * @return a size of the groups container.
     */
    public int groupsAmount() { return groups.size(); }

    /**
     * This method finds amount of teachers in the teachers container.
     * @return a size of the teachers container.
     */
    public int teachersAmount() { return teachers.size(); }

    /**
     * Two objects of the class Department are equals if their groups and teachers containers are equals.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Department department = (Department) obj;

        return groups.equals(department.groups) && teachers.equals(department.teachers);
    }

    /**
     * The Department object hash code is the linear combination of sizes of the groups and teachers containers.
     */
    @Override
    public int hashCode() {
        return groups.size() + 1000 * teachers.size();
    }

    @Override
    public String toString() {
        return "Department. " + groups.size() + " groups.";
    }
}