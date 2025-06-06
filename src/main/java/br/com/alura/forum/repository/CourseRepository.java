package br.com.alura.forum.repository;

import br.com.alura.forum.modelo.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Course findByName(String courseName);
}
