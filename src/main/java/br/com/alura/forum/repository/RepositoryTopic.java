package br.com.alura.forum.repository;

import br.com.alura.forum.modelo.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryTopic extends JpaRepository<Topic, Long> {
    //JpaRepository<the entity this repository will work with, the primary key attribute of this entity>

    //@Query("SELECT t FROM Topico t WHERE t.course_name = :courseName") -> can also be used to force this specific query
    List<Topic> findByCourse_Name(String courseName);
}
