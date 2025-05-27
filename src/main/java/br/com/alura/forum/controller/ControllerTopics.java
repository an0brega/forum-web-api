package br.com.alura.forum.controller;

import br.com.alura.forum.controller.dto.TopicDto;
import br.com.alura.forum.controller.form.TopicForm;
import br.com.alura.forum.modelo.Topic;
import br.com.alura.forum.repository.CourseRepository;
import br.com.alura.forum.repository.RepositoryTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController // assumes that every method has the @ResponseBody by default
@RequestMapping("/topics") // all requests do /topics will get here
public class ControllerTopics {

    @Autowired
    private RepositoryTopic repositoryTopic; //injecting the repository

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<TopicDto> list(String courseName){
        if(courseName == null) {
            List<Topic> topics = repositoryTopic.findAll(); //since we are extending the JpaRepository class, we have access to this findAll() method.
            return TopicDto.convertTo(topics); // this method will return an object as a list
        }
        else{
            List<Topic> topics = repositoryTopic.findByCourse_Name(courseName);
            return TopicDto.convertTo(topics);
        }

        // this list will be returned as a String, the jackson converts the jackson to json
    }

    @PostMapping
    public ResponseEntity<TopicDto> register(@RequestBody TopicForm form, UriComponentsBuilder uriBuilder){ //@RequestBody means that the request will come not by the URL, but by the body
        Topic topic = form.convertTo(courseRepository);
        repositoryTopic.save(topic);

        URI uri = uriBuilder.path("/topic/{id}").buildAndExpand(topic.getId()).toUri(); //the {id} is generated sequentially by the database
        // Builds the URI of the newly created resource using the topic's ID (e.g., /topic/123).
        // This is typically used to set the Location header in the response of a POST request.
        // uriBuilder is a helper provided by Spring to dynamically construct URLs.

        return ResponseEntity.created(uri).body(new TopicDto(topic));
    }
}
