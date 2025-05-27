package br.com.alura.forum.controller.form;

import br.com.alura.forum.modelo.Course;
import br.com.alura.forum.modelo.Topic;
import br.com.alura.forum.repository.CourseRepository;
import br.com.alura.forum.repository.RepositoryTopic;

public class TopicForm {

    private String title;
    private String message;
    private String courseName;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Topic convertTo(CourseRepository repository){
        Course course = repository.findByName(courseName);
        return new Topic(title, message, course);
    }
}