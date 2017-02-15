package ua.edu.university.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ua.edu.university.data.model.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long> {

    Department findByName(@Param("name") String name);

}
