package object.model;

import java.time.LocalDate;

public class Livre {
	
	private Integer id;
	private String title;
	private LocalDate publishedAt;
	
	public Livre(Integer id, String title, LocalDate publishedAt) {
		this.id = id;
		this.title = title;
		this.publishedAt = publishedAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(LocalDate publishedAt) {
		this.publishedAt = publishedAt;
	}
	
	
	
}
