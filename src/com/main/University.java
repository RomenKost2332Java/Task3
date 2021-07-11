package com.main;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The class to containing and processing an information about an university (Contain and process faculties).
 *
 * @author Kostenko Roman
 */
public class University {
    /**
     * The faculties container.
     */
    private Set<Faculty> faculties = new HashSet<>();

    /**
     * An empty constructor.
     */
    public University() {

    }

    /**
     * This constructor adds faculty to the faculties container during creating object of this class.
     *
     * @param faculty - a faculty to adding to the faculties container.
     */
    public University(Faculty faculty) {
        faculties = new HashSet<>();
        faculties.add(faculty);
        setFaculties(faculties);
    }

    /**
     * This constructor adds faculties from the set to the faculties container during creating object of this
     * class.
     *
     * @param faculties - a set of faculties to setting to the faculties container.
     */
    public University(Set<Faculty> faculties)  {
        setFaculties(faculties);
    }

    /**
     * The getter of the faculties container.
     *
     * @return a copy of the container of faculties.
     */
    public Set<Faculty> getFaculties() {
        return Set.copyOf(faculties);
    }

    /**
     * The setter of the faculties container.
     *
     * @param faculties - a set of faculties to setting to the faculties container.
     */
    public void setFaculties(Set<Faculty> faculties) {
        this.faculties = new HashSet<>(faculties);
    }

    /**
     * This method adds the faculty to the faculties container.
     *
     * @param faculty - the faculty to adding to the faculties container.
     */
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    /**
     * This method adds the all faculties from the set to the faculties container.
     *
     * @param faculties - the faculties set to adding to the faculties container.
     */
    public void addFaculties(Set<Faculty> faculties) {
        this.faculties.addAll(faculties);
    }

    /**
     * This method removes the faculty from the faculties container.
     *
     * @param faculty - the faculty to removing from the faculties container.
     */
    public void removeFaculty(Faculty faculty) {
        faculties.remove(faculty);
    }

    /**
     * This method removes from the faculties container the all faculties from the faculties set.
     *
     * @param faculties - the set of faculties to removing from the faculties container.
     */
    public void removeFaculties(Set<Faculty> faculties) {
        this.faculties.removeAll(faculties);
    }

    /**
     * This method finds amount of faculties in the faculties container.
     *
     * @return a size of the faculties container.
     */
    public int facultiesAmount() {
        return faculties.size();
    }

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
