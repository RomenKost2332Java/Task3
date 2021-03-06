package com.main;

import exceptions.NotEnoughDepartmentsException;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The class to containing and processing an information about a faculty (Contains and processes departments).
 *
 * @author Kostenko Roman
 */
public class Faculty {
    /**
     * Min amount departments that may contain faculty in an university.
     */
    public static final int MIN_AMOUNT_DEPARTMENTS = 1;

    /**
     * The departments container.
     */
    private Set<Department> departments = new HashSet<>();

    /**
     * This constructor sets departments from the set to the departments container during creating object of this
     * class.
     *
     * @param departments - a set of departments to setting to the departments container.
     * @throws NotEnoughDepartmentsException if the departments container won't have enough departments after setting.
     */
    public Faculty(Set<Department> departments) throws NotEnoughDepartmentsException {
        setDepartments(departments);
    }

    /**
     * The getter of the departments container.
     *
     * @return a copy of the container of departments.
     */
    public Set<Department> getDepartments() {
        return Set.copyOf(departments);
    }

    /**
     * The setter of the departments container.
     *
     * @param departments - a set of departments to setting to the departments container.
     * @throws NotEnoughDepartmentsException if the departments container won't have enough departments after setting.
     */
    public void setDepartments(Set<Department> departments) throws NotEnoughDepartmentsException {
        if (departments.size() < MIN_AMOUNT_DEPARTMENTS){
            throw new NotEnoughDepartmentsException();
        }
        this.departments = new HashSet<>(departments);
    }

    /**
     * This method adds the department to the faculties container.
     *
     * @param department - the department to adding to the departments container.
     */
    public void addDepartment(Department department) {
        departments.add(department);
    }

    /**
     * This method adds the all departments from the set to the departments container.
     *
     * @param departments - the departments set to adding to the departments container.
     */
    public void addDepartments(Set<Department> departments) {
        this.departments.addAll(departments);
    }

    /**
     * This method removes the department from the departments container.
     *
     * @param department - the faculty to removing from the departments container.
     * @throws NotEnoughDepartmentsException if the departments container won't have enough departments after removing.
     */
    public void removeDepartment(Department department) throws NotEnoughDepartmentsException {
        if (departments.size() == MIN_AMOUNT_DEPARTMENTS && departments.contains(department)) {
            throw new NotEnoughDepartmentsException();
        }
        departments.remove(department);
    }

    /**
     * This method removes from the departments container the all departments from the departments set.
     *
     * @param departments - the set of departments to removing from the departments container.
     * @throws NotEnoughDepartmentsException if the departments container won't have enough departments after removing.
     */
    public void removeDepartments(Set<Department> departments) throws NotEnoughDepartmentsException {
        Set<Department> backUp = Set.copyOf(this.departments);
        this.departments.removeAll(departments);
        if (this.departments.size() < MIN_AMOUNT_DEPARTMENTS) {
            this.departments = backUp;
            throw new NotEnoughDepartmentsException();
        }
    }

    /**
     * This method finds amount of departments in the departments container.
     *
     * @return a size of the departments container.
     */
    public int departmentAmount() {
        return departments.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(departments, faculty.departments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departments);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "departments=" + departments +
                '}';
    }
}
