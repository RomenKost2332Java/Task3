package com.main;

import exceptions.NotEnoughGroupsException;
import exceptions.NotEnoughTeachersException;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Department {
    /**
     * Min amount groups that may contain a department.
     */
    public static final int MIN_GROUPS_AMOUNT = 1;

    /**
     * Min amount teachers that may contain a department.
     */
    public static final int MIN_TEACHERS_AMOUNT = 3;

    /**
     * The groups container.
     */
    private Set<Group> groups = new HashSet<>();

    /**
     * The teachers container.
     */
    private Set<Teacher> teachers = new HashSet<>();

    /**
     * This constructor adds groups from the groups set to the groups container and teachers from the teachers
     * set to the teachers container during creating object of this class.
     *
     * @param groups   - the set of groups to setting to the groups container.
     * @param teachers - the set of teachers to setting to the teachers container.
     * @throws NotEnoughGroupsException   if the groups container won't have enough groups after setting.
     * @throws NotEnoughTeachersException if the teachers container won't have enough teachers after setting.
     */
    public Department(Set<Group> groups, Set<Teacher> teachers) throws NotEnoughGroupsException, NotEnoughTeachersException {
        setGroups(groups);
        setTeachers(teachers);
    }

    /**
     * The getter of the groups container.
     *
     * @return the copy of the container of groups.
     */
    public Set<Group> getGroups() {
        return Set.copyOf(groups);
    }

    /**
     * The getter of the teachers container.
     *
     * @return the copy of the container of teachers.
     */
    public Set<Teacher> getTeachers() {
        return Set.copyOf(teachers);
    }

    /**
     * The setter of the groups container.
     *
     * @param groups - the set of groups to setting to the groups container.
     * @throws NotEnoughGroupsException if the groups container won't have enough groups after setting.
     */
    public void setGroups(Set<Group> groups) throws NotEnoughGroupsException {
        if (MIN_GROUPS_AMOUNT > groups.size()) {
            throw new NotEnoughGroupsException();
        }
        this.groups = new HashSet<>(groups);
    }

    /**
     * The setter of the teachers container.
     *
     * @param teachers - to set of teachers to setting to the teachers container.
     * @throws NotEnoughTeachersException if the teachers container won't have enough teachers after setting.
     */
    public void setTeachers(Set<Teacher> teachers) throws NotEnoughTeachersException {
        if (MIN_TEACHERS_AMOUNT > teachers.size()) {
            throw new NotEnoughTeachersException();
        }
        this.teachers = new HashSet<>(teachers);
    }

    /**
     * This method adds the group to the groups container.
     *
     * @param group - the group to adding to the groups container.
     */
    public void addGroup(Group group) {
        groups.add(group);
    }

    /**
     * This method adds the all groups from the set to the groups container.
     *
     * @param groups - the groups set to adding to the groups container.
     */
    public void addGroups(Set<Group> groups) {
        this.groups.addAll(groups);
    }

    /**
     * This method removes the group from the groups container.
     *
     * @param group - the group to removing from the groups container.
     * @throws NotEnoughGroupsException if the groups container won't have enough groups after removing.
     */
    public void removeGroup(Group group) throws NotEnoughGroupsException {
        if (groups.size() == MIN_GROUPS_AMOUNT && groups.contains(group)) {
            throw new NotEnoughGroupsException();
        }
        groups.remove(group);
    }

    /**
     * This method removes from the groups container the all groups from the groups set.
     *
     * @param groups - the set of groups to removing from the groups container.
     * @throws NotEnoughGroupsException if the groups container won't have enough groups after removing.
     */
    public void removeGroups(Set<Group> groups) throws NotEnoughGroupsException {
        Set<Group> backUp = Set.copyOf(this.groups);
        this.groups.removeAll(groups);
        if (this.groups.size() < MIN_GROUPS_AMOUNT) {
            this.groups = backUp;
            throw new NotEnoughGroupsException();
        }
    }

    /**
     * This method adds the teacher to the teachers container.
     *
     * @param teacher - the teacher to adding to the teachers container.
     */
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    /**
     * This method adds the all teachers from the set to the teachers container.
     *
     * @param teachers - the teachers set to adding to the teachers container.
     */
    public void addTeachers(Set<Teacher> teachers) {
        this.teachers.addAll(teachers);
    }

    /**
     * This method removes the teacher from the teachers container.
     *
     * @param teacher - the teacher to removing from the teachers container.
     * @throws NotEnoughTeachersException if the teachers container won't have enough teachers after removing.
     */
    public void removeTeacher(Teacher teacher) throws NotEnoughTeachersException {
        if (teachers.size() == MIN_TEACHERS_AMOUNT && teachers.contains(teacher)) {
            throw new NotEnoughTeachersException();
        }
        teachers.remove(teacher);
    }

    /**
     * This method removes from the teachers container the all teachers from the teachers set.
     *
     * @param teachers - the set of teachers to removing from the teachers container.
     * @throws NotEnoughTeachersException if the teachers container won't have enough teachers after removing.
     */
    public void removeTeachers(Set<Teacher> teachers) throws NotEnoughTeachersException {
        Set<Teacher> backUp = Set.copyOf(this.teachers);
        this.teachers.removeAll(teachers);
        if (groups.size() < MIN_GROUPS_AMOUNT) {
            this.teachers = backUp;
            throw new NotEnoughTeachersException();
        }
    }

    /**
     * This method finds amount of teachers in the teachers container.
     *
     * @return a size of the teachers container.
     */
    public int groupsAmount() {
        return groups.size();
    }

    /**
     * This method finds amount of groups in the groups container.
     *
     * @return a size of the groups container.
     */
    public int teachersAmount() {
        return teachers.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(groups, that.groups) &&
                Objects.equals(teachers, that.teachers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groups, teachers);
    }

    @Override
    public String toString() {
        return "Department{" +
                "groups=" + groups +
                ", teachers=" + teachers +
                '}';
    }
}