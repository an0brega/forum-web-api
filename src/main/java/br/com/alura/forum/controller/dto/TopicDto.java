package br.com.alura.forum.controller.dto;

import br.com.alura.forum.modelo.Topic;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

// Dto -> Data Transfer Object
// This Dto class will force to return just this specific attributes from Topic instead of returning the whole class.
public class TopicDto {

    private Long id;
    private String title;
    private String message;
    private LocalDateTime creationDate;

    public TopicDto(Topic topic) {
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.creationDate = topic.getCreationDate();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }


    public static List<TopicDto> convertTo(List<Topic> topics) {
        return topics.stream().map(TopicDto::new).collect(Collectors.toList());

        // explaining the return
        // .map(TopicDto::new) -> maps a Topic to a Topics DTO. "::new" means that I want the constructor that receives the Topic
        // as a parameter
        // .collect -> transforms this into a List
    }
}
