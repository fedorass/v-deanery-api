package ua.edu.university.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;

@Entity
public class Department {

    private long id;
    private String name;
    private Collection<Faculty> faculties;

    public Department() {
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

    @ManyToMany(mappedBy = "departments")
    public Collection<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(Collection<Faculty> faculties) {
        this.faculties = faculties;
    }
}
