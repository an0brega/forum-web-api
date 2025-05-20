package br.com.alura.forum.controller;

import br.com.alura.forum.controller.dto.TopicDto;
import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topic;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController // assumes that every method has the @ResponseBody by default
public class ControllerTopics {

    @RequestMapping("/topics")
    public List<TopicDto> List(){
        Topic topico = new Topic("Dúvida", "Dúvida com Spring", new Curso("Spring", "Programação"));

        return TopicDto.convertTo(Arrays.asList(topico, topico, topico)); // this method will return an object as a list
        // this list will be returned as a String, the jackson converts the jackson to json
    }
}
