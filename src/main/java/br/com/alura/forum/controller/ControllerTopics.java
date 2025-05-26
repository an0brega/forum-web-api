package br.com.alura.forum.controller;

import br.com.alura.forum.controller.dto.TopicDto;
import br.com.alura.forum.modelo.Topic;
import br.com.alura.forum.repository.RepositoryTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // assumes that every method has the @ResponseBody by default
public class ControllerTopics {

    @Autowired
    private RepositoryTopic repositoryTopic; //injecting the repository

    @RequestMapping("/topics")
    public List<TopicDto> List(String courseName){
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
}
