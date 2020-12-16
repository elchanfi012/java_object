package object.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Livre implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	private Integer id;
	private String title;
	private LocalDate publishedAt;
	private List<Emprunt> emprunts;
	
	public Livre(Integer id, String title, LocalDate publishedAt) {
		this.id = id;
		this.title = title;
		this.publishedAt = publishedAt;
		this.emprunts = new ArrayList<Emprunt>();
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

	public List<Emprunt> getEmprunts() {
		return emprunts;
	}

	public void addEmprunt(Emprunt emprunt) {
		this.emprunts.add(emprunt);
	}
	
	public void removeEmprunt(int index) {
		this.emprunts.remove(index);
	}

	@Override
	public String toString() {
		
		return "Livre {\n id=" + id + ", title=" + title + ", publishedAt=" + publishedAt 
				+ ", \n emprunts=" + emprunts + "\n}";
	}
	
	
	
}
