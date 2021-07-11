package com.main;

import exceptions.NotEnoughDepartmentsException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The class to containing and processing an information about an university (Contain and process faculties).
 * @author Kostenko Roman
 */
public class University {
    /**
     * The faculties container.
     */
    private HashSet<Faculty> faculties = new HashSet<>();

    /**
     * An empty constructor.
     */
    public University() {}

    /**
     * This constructor adds faculty to the faculties container during creating object of this class.
     * @param faculty - a faculty to adding to the faculties container.
     * @throws NotEnoughDepartmentsException if the faculty haven't enough departments.
     */
    public University(Faculty faculty) throws NotEnoughDepartmentsException { addFaculty(faculty); }

    /**
     * This constructor adds faculties from the collection to the faculties container during creating object of this
     * class.
     * @param faculties - a collection of faculties to setting to the faculties container.
     * @throws NotEnoughDepartmentsException if a faculty that haven't enough departments exists in the collection.
     */
    public University(Collection<Faculty> faculties) throws NotEnoughDepartmentsException { addFaculties(faculties); }

    /**
     * The getter of the faculties container.
     * @return a copy of the container of faculties.
     */
    public Set<Faculty> getFaculties() { return Set.copyOf(faculties); }

    /**
     * The setter of the faculties container.
     * @param faculties - a collection of faculties to setting to the faculties container.
     * @throws NotEnoughDepartmentsException if a faculty that haven't enough departments exists in the collection.
     */
    public void setFaculties(Collection<Faculty> faculties) throws NotEnoughDepartmentsException {
        HashSet<Faculty> backUp = (HashSet<Faculty>) Set.copyOf(this.faculties);
        this.faculties = new HashSet<>();
        try {
            addFaculties(faculties);
        } catch (NotEnoughDepartmentsException e) {
            this.faculties = backUp;
            throw e;
        }
    }

    /**
     * This method adds the faculty to the faculties container.
     * @param faculty - the faculty to adding to the faculties collection.
     * @throws NotEnoughDepartmentsException if the faculty haven't enough departments.
     */
    public void addFaculty(Faculty faculty) throws NotEnoughDepartmentsException {
        if (Faculty.MIN_AMOUNT_DEPARTMENTS > faculty.departmentAmount()){
            throw new NotEnoughDepartmentsException();
        }
        faculties.add(faculty);
    }

    /**
     * This method adds the all faculties from the collection to the faculties container.
     * @param faculties - the faculties collection to adding to the faculties container.
     * @throws NotEnoughDepartmentsException if a faculty that haven't enough departments exists in the collection.
     */
    public void addFaculties(Collection<Faculty> faculties) throws NotEnoughDepartmentsException {
        HashSet<Faculty> backUp = this.faculties;
        try {
            for (Faculty faculty : faculties) {
                addFaculty(faculty);
            }
        } catch (NotEnoughDepartmentsException e) {
            this.faculties = backUp;
            throw e;
        }
    }

    /**
     * This method removes the faculty from the faculties container.
     * @param faculty - the faculty to removing from the faculties container.
     */
    public void removeFaculty(Faculty faculty){ faculties.remove(faculty); }

    /**
     * This method removes from the faculties container the all faculties from the faculties collection.
     * @param faculties - the collection of faculties to removing from the faculties container.
     */
    public void removeFaculties(Collection<Faculty> faculties) {this.faculties.removeAll(faculties);}

    /**
     * This method finds amount of faculties in the faculties container.
     * @return a size of the faculties container.
     */
    public int facultiesAmount(){ return faculties.size(); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return Objects.equals(faculties, that.faculties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculties);
    }

    @Override
    public String toString() {
        return "University{" +
                "faculties=" + faculties +
                '}';
    }
}
