package br.com.alura.forum.controller;

import br.com.alura.forum.controller.dto.DetailsTopicDto;
import br.com.alura.forum.controller.dto.TopicDto;
import br.com.alura.forum.controller.form.TopicForm;
import br.com.alura.forum.controller.form.UpdateTopicForm;
import br.com.alura.forum.modelo.Topic;
import br.com.alura.forum.repository.CourseRepository;
import br.com.alura.forum.repository.RepositoryTopic;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
    @Transactional
    public ResponseEntity<TopicDto> register(@RequestBody @Valid TopicForm form, UriComponentsBuilder uriBuilder){
        //@RequestBody means that the request will come not by the URL, but by the body
        //@Valid will force the object to be validated using the bean validations inside the TopicForm class

        Topic topic = form.convertTo(courseRepository);
        repositoryTopic.save(topic);

        URI uri = uriBuilder.path("/topic/{id}").buildAndExpand(topic.getId()).toUri(); //the {id} is generated sequentially by the database
        // Builds the URI of the newly created resource using the topic's ID (e.g., /topic/123).
        // This is typically used to set the Location header in the response of a POST request.
        // uriBuilder is a helper provided by Spring to dynamically construct URLs.

        return ResponseEntity.created(uri).body(new TopicDto(topic));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailsTopicDto> detail(@PathVariable("id") Long code){ //@PathVariable -> means that the id is a part of the URL
        Optional<Topic> topic = repositoryTopic.findById(code);
        if (topic.isPresent())
            return ResponseEntity.ok(new DetailsTopicDto(topic.get())); // -> ".get()" gets the Topic and not Optional class

        return ResponseEntity.notFound().build();

    }

    @PutMapping("/{id}") // PUT - overwrite the info. PATCH - update the info
    @Transactional // -> says to spring that the change should be updated in the database
    public ResponseEntity<TopicDto> update(@PathVariable("id") Long code, @RequestBody @Valid UpdateTopicForm form){
        Optional<Topic> optionalTopic = repositoryTopic.findById(code);
        if (optionalTopic.isPresent()) {
            Topic topic = form.update(code, repositoryTopic);
            return ResponseEntity.ok(new TopicDto(optionalTopic.get()));
        }

        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remove(@PathVariable("id") Long code){
        Optional<Topic> optionalTopic = repositoryTopic.findById(code);
        if (optionalTopic.isPresent()) {
            repositoryTopic.deleteById(code);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}
