package com.main;

import exceptions.NotEnoughDepartmentsException;

import java.util.Collection;
import java.util.HashSet;

public abstract class University {
    private HashSet<Faculty> faculties = new HashSet<>();

    University() {}
    University(Faculty faculty) throws NotEnoughDepartmentsException {
        addFaculty(faculty);
    }
    University(Collection<Faculty> faculties) throws NotEnoughDepartmentsException {
        addFaculties(faculties);
    }

    private void addFaculty(Faculty faculty) throws NotEnoughDepartmentsException {
        if (Faculty.minAmountDepartments > faculty.departmentAmount())
            throw new NotEnoughDepartmentsException();
        faculties.add(faculty);
    }

    private void addFaculties(Collection<Faculty> faculties) throws NotEnoughDepartmentsException {
        for (Faculty faculty : faculties)
            addFaculty(faculty);
    }
}
