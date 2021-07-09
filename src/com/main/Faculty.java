package com.main;

import exceptions.NotEnoughDepartmentsException;
import exceptions.NotEnoughGroupsException;
import exceptions.NotEnoughTeachersException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public abstract class Faculty {
    public static final int MIN_AMOUNT_DEPARTMENTS = 1;

    private HashSet<Department> departments = new HashSet<>();

    public Faculty() {}
    public Faculty(Collection<Department> departments) throws NotEnoughTeachersException, NotEnoughGroupsException {
        addDepartments(departments);
    }

    public Set<Department> getDepartments() { return Set.copyOf(departments); }

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

    public void addDepartment(Department department) throws NotEnoughGroupsException, NotEnoughTeachersException {
        if (Department.MIN_GROUPS_AMOUNT > department.groupsAmount()){
            throw new NotEnoughGroupsException();
        }
        if (Department.MIN_TEACHERS_AMOUNT > department.teachersAmount()){
            throw new NotEnoughTeachersException();
        }
        departments.add(department);
    }

    public void addDepartments(Collection<Department> departments) throws NotEnoughTeachersException, NotEnoughGroupsException {
        for(Department department : departments){
            addDepartment(department);
        }
    }

    public void removeDepartments(Department department) throws NotEnoughDepartmentsException {
        if (departments.size() == MIN_AMOUNT_DEPARTMENTS && departments.contains(department)){
            throw new NotEnoughDepartmentsException();
        }
        departments.remove(department);
    }

    public void removeDepartments(Collection<Department> departments) throws NotEnoughDepartmentsException {
        HashSet<Department> backUp = (HashSet<Department>) Set.copyOf(this.departments);
        this.departments.removeAll(departments);
        if (this.departments.size() < MIN_AMOUNT_DEPARTMENTS) {
            this.departments = backUp;
            throw new NotEnoughDepartmentsException();
        }
    }

    public int departmentAmount(){ return departments.size(); }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Faculty faculty = (Faculty) obj;

        return departments.equals(faculty.departments);
    }

    @Override
    public int hashCode() {
        return departments.size();
    }

    @Override
    public String toString() {
        return "Faculty. " + departments.size() + " departments.";
    }
}
