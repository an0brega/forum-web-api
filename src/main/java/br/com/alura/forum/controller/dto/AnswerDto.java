package br.com.alura.forum.controller.dto;

import br.com.alura.forum.modelo.Answer;

import java.time.LocalDateTime;

public class AnswerDto {

    private Long id;
    private String messageSent;
    private LocalDateTime creationDate;
    private String authorName;

    public AnswerDto(Answer answer) {
        this.id = answer.getId();
        this.messageSent = answer.getMessage();
        this.creationDate = answer.getCreationDate();
        this.authorName = answer.getAuthor().getName();
    }

    public Long getId() {
        return id;
    }

    public String getMessageSent() {
        return messageSent;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getAuthorName() {
        return authorName;
    }
}
