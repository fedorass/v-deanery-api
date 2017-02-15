package ua.edu.university.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayDeque;
import java.util.Collection;

@Entity
public class Faculty {

    private long id;
    private String name;
    private Collection<Department> departments = new ArrayDeque<>();

    public Faculty() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany
    @JoinTable(name = "FACILITIES", joinColumns = @JoinColumn(name = "FACULTY_ID"), inverseJoinColumns = @JoinColumn(name = "DEPARTMENT_ID"))
    public Collection<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Collection<Department> departments) {
        this.departments = departments;
    }
}
