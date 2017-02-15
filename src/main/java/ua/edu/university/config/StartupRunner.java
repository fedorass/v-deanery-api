package ua.edu.university.config;

import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import ua.edu.university.data.model.Department;
import ua.edu.university.data.model.Faculty;
import ua.edu.university.data.repository.DepartmentRepository;
import ua.edu.university.data.repository.FacultyRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Profile("development")
@Component
@Transactional
public class StartupRunner implements CommandLineRunner {

    private Map<String, List<String>> facilitiesMap = ImmutableMap.<String, List<String>>builder()
            .put("Математики та інформатики", Arrays.asList("Інформатики та прикладної математики",
                                            "Інформаційно-комунікаційних технологій та методики викладання інформатики",
                                            "Вищої математики",
                                            "Математики та методики її викладання",
                                            "Фізичного виховання"))
            .build();

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("StartupRunner....");

        /*for(String facultyName : facilitiesMap.keySet()) {

            Faculty faculty = facultyRepository.findByName(facultyName);

            for(String departmentName : facilitiesMap.get(facultyName)) {
                Department department = departmentRepository.findByName(departmentName);

                faculty.getDepartments().add(department);
                department.getFaculties().add(faculty);
            }
        }*/
    }

}
