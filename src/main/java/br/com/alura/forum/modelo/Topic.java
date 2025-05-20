package br.com.alura.forum.modelo;

import br.com.alura.forum.enums.StatusTopico;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Topic {

	private Long id;
	private String title;
	private String message;
	private LocalDateTime creationDate = LocalDateTime.now();
	private StatusTopico status = StatusTopico.NAO_RESPONDIDO;
	private Usuario author;
	private Curso course;
	private List<Resposta> answers = new ArrayList<>();

	public Topic(String title, String message, Curso curso) {
		this.title = title;
		this.message = message;
		this.course = curso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topic other = (Topic) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public StatusTopico getStatus() {
		return status;
	}

	public void setStatus(StatusTopico status) {
		this.status = status;
	}

	public Usuario getAuthor() {
		return author;
	}

	public void setAuthor(Usuario author) {
		this.author = author;
	}

	public Curso getCourse() {
		return course;
	}

	public void setCourse(Curso course) {
		this.course = course;
	}

	public List<Resposta> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Resposta> answers) {
		this.answers = answers;
	}

}
