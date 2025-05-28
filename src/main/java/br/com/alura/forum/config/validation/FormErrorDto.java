package br.com.alura.forum.config.validation;

/// Represents an error from the field imputed in the TopicForm
public class FormErrorDto {

    private String field;
    private String error;

    public FormErrorDto(String field, String error) {
        this.field = field;
        this.error = error;
    }

    public String getField() {
        return field;
    }

    public String getError() {
        return error;
    }
}
