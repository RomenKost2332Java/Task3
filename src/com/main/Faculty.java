package com.main;

import exceptions.NotEnoughGroupsException;
import exceptions.NotEnoughTeachersException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public abstract class Faculty {
    public static final int minAmountDepartments = 1;

    private HashSet<Department> departments = new HashSet<>();

    public Set<Department> getDepartments() {
        return Set.copyOf(departments);
    }

    public void addDepartment(Department department) throws NotEnoughGroupsException, NotEnoughTeachersException {
        if (Department.minGroupsAmount > department.groupsAmount())
            throw new NotEnoughGroupsException();
        if (Department.minTeachersAmount > department.teachersAmount())
            throw new NotEnoughTeachersException();
        departments.add(department);
    }

    public void addDepartments(Collection<Department> departments) throws NotEnoughTeachersException, NotEnoughGroupsException {
        for(Department department : departments)
            addDepartment(department);
    }

    public int departmentAmount(){
        return departments.size();
    }
}
