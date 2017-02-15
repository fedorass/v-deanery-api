package ua.edu.university.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ua.edu.university.data.model.Faculty;

public interface FacultyRepository extends CrudRepository<Faculty, Long> {

    Faculty findByName(@Param("name") String name);

}
