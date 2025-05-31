package br.com.alura.forum.controller.form;

import br.com.alura.forum.modelo.Topic;
import br.com.alura.forum.repository.RepositoryTopic;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateTopicForm {

    @NotNull
    @NotBlank
    @Size(min = 5)
    private String title;

    @NotNull @NotBlank @Size(min = 10)
    private String message;

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

    public Topic update (Long id, RepositoryTopic repositoryTopic){
        Topic topic = repositoryTopic.getOne(id);

        topic.setTitle(this.title);
        topic.setMessage(this.message);

        return topic;
    }
}