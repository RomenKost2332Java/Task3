package com.main;

import exceptions.NotEnoughDepartmentsException;

import java.util.Collection;
import java.util.HashSet;

public abstract class University {
    private HashSet<Faculty> faculties = new HashSet<>();

    University() {}
    University(Faculty faculty) throws NotEnoughDepartmentsException { addFaculty(faculty); }
    University(Collection<Faculty> faculties) throws NotEnoughDepartmentsException { addFaculties(faculties); }

    public void addFaculty(Faculty faculty) throws NotEnoughDepartmentsException {
        if (Faculty.minAmountDepartments > faculty.departmentAmount()){
            throw new NotEnoughDepartmentsException();
        }
        faculties.add(faculty);
    }

    public void addFaculties(Collection<Faculty> faculties) throws NotEnoughDepartmentsException {
        for (Faculty faculty : faculties){
            addFaculty(faculty);
        }
    }

    public void removeFaculty(Faculty faculty){ faculties.remove(faculty); }
    public void removeFaculties(Collection<Faculty> faculties) {this.faculties.removeAll(faculties);}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        University university = (University) obj;

        return faculties.equals(university.faculties);
    }

    @Override
    public int hashCode() {
        return faculties.size();
    }
}
