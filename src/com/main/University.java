package com.main;

import exceptions.NotEnoughDepartmentsException;
import exceptions.WrongElementsAmountException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public abstract class University {
    private HashSet<Faculty> faculties = new HashSet<>();

    public University() {}
    public University(Faculty faculty) throws NotEnoughDepartmentsException { addFaculty(faculty); }
    public University(Collection<Faculty> faculties) throws NotEnoughDepartmentsException { addFaculties(faculties); }

    public Set<Faculty> getFaculties() {
        return Set.copyOf(faculties);
    }

    public void setFaculties(Collection<Faculty> faculties) throws NotEnoughDepartmentsException {
        HashSet<Faculty> backUp = (HashSet<Faculty>) Set.copyOf(this.faculties);
        this.faculties = new HashSet<>();
        try {
            addFaculties(faculties);
        }
        catch (NotEnoughDepartmentsException e) {
            this.faculties = backUp;
            throw e;
        }
    }

    public void addFaculty(Faculty faculty) throws NotEnoughDepartmentsException {
        if (Faculty.MIN_AMOUNT_DEPARTMENTS > faculty.departmentAmount()){
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

    public int facultiesAmount(){ return faculties.size(); }

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

    @Override
    public String toString() {
        return "University. " + faculties.size() + " faculties.";
    }
}
