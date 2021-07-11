package com.main;

import exceptions.NotEnoughDepartmentsException;
import exceptions.NotEnoughGroupsException;
import exceptions.NotEnoughTeachersException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * The class to containing and processing an information about a faculty (Contains and processes departments).
 * @author Kostenko Roman
 */
public abstract class Faculty {
    /**
     * Min amount departments that may contain faculty in an university.
     */
    public static final int MIN_AMOUNT_DEPARTMENTS = 1;

    /**
     * The departments container.
     */
    private HashSet<Department> departments = new HashSet<>();

    /**
     * An empty constructor.
     */
    public Faculty() {}

    /**
     * This constructor sets departments from the collection to the departments container during creating object of this
     * class.
     * @param departments - a collection of departments to setting to the departments container.
     * @throws NotEnoughTeachersException if a department that haven't enough teachers exists in the collection.
     * @throws NotEnoughGroupsException if a department that haven't enough groups exists in the collection.
     */
    public Faculty(Collection<Department> departments) throws NotEnoughTeachersException, NotEnoughGroupsException {
        addDepartments(departments);
    }

    /**
     * The getter of the departments container.
     * @return a copy of the container of departments.
     */
    public Set<Department> getDepartments() { return Set.copyOf(departments); }

    /**
     * The setter of the departments container.
     * @param departments - a collection of departments to adding to the departments container.
     * @throws NotEnoughTeachersException if a department that haven't enough teachers exists in the collection.
     * @throws NotEnoughGroupsException if a department that haven't enough groups exists in the collection.
     */
    public void setDepartments(Collection<Department> departments) throws NotEnoughTeachersException, NotEnoughGroupsException {
        HashSet<Department> backUp = (HashSet<Department>) Set.copyOf(this.departments);
        this.departments = new HashSet<>();
        try {
            addDepartments(departments);
        } catch (NotEnoughGroupsException | NotEnoughTeachersException e) {
            this.departments = backUp;
            throw e;
        }
    }

    /**
     * This method adds the department to the faculties container.
     * @param department - the department to adding to the departments collection.
     * @throws NotEnoughGroupsException if the department haven't enough groups.
     * @throws NotEnoughTeachersException if the department haven't enough teachers.
     */
    public void addDepartment(Department department) throws NotEnoughGroupsException, NotEnoughTeachersException {
        if (Department.MIN_GROUPS_AMOUNT > department.groupsAmount()){
            throw new NotEnoughGroupsException();
        }
        if (Department.MIN_TEACHERS_AMOUNT > department.teachersAmount()){
            throw new NotEnoughTeachersException();
        }
        departments.add(department);
    }

    /**
     * This method adds the all departments from the collection to the departments container.
     * @param departments - the departments collection to adding to the departments container.
     * @throws NotEnoughGroupsException if a department that haven't enough groups exists in the collection.
     * @throws NotEnoughTeachersException if a department that haven't enough teachers exists in the collection.
     */
    public void addDepartments(Collection<Department> departments) throws NotEnoughTeachersException, NotEnoughGroupsException {
        for(Department department : departments){
            addDepartment(department);
        }
    }

    /**
     * This method removes the department from the departments container.
     * @param department - the faculty to removing from the departments container.
     * @throws NotEnoughDepartmentsException if the departments container won't have enough departments after removing.
     */
    public void removeDepartment(Department department) throws NotEnoughDepartmentsException {
        if (departments.size() == MIN_AMOUNT_DEPARTMENTS && departments.contains(department)){
            throw new NotEnoughDepartmentsException();
        }
        departments.remove(department);
    }

    /**
     * This method removes from the departments container the all departments from the departments collection.
     * @param departments - the collection of departments to removing from the departments container.
     * @throws NotEnoughDepartmentsException if the departments container won't have enough departments after removing.
     */
    public void removeDepartments(Collection<Department> departments) throws NotEnoughDepartmentsException {
        HashSet<Department> backUp = (HashSet<Department>) Set.copyOf(this.departments);
        this.departments.removeAll(departments);
        if (this.departments.size() < MIN_AMOUNT_DEPARTMENTS) {
            this.departments = backUp;
            throw new NotEnoughDepartmentsException();
        }
    }

    /**
     * This method finds amount of departments in the departments container.
     * @return a size of the departments container.
     */
    public int departmentAmount(){ return departments.size(); }

    /**
     * Two objects of the class Faculty are equals if their departments containers are equals.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Faculty faculty = (Faculty) obj;

        return departments.equals(faculty.departments);
    }

    /**
     * The Faculty object hash code is the size of the departments container.
     */
    @Override
    public int hashCode() {
        return departments.size();
    }

    @Override
    public String toString() {
        return "Faculty. " + departments.size() + " departments.";
    }
}
