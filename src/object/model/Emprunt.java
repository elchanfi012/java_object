package object.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Emprunt {
	
	private LocalDate borrowedAt;
	private LocalDate renderedAt;
	private String borrowerName;
	private List<Emprunt> emprunts;
	
	

	public Emprunt(LocalDate borrowedAt, LocalDate renderedAt, String borrowerName) {
		this.borrowedAt = borrowedAt;
		this.renderedAt = renderedAt;
		this.borrowerName = borrowerName;
		this.emprunts = new ArrayList<Emprunt>();
	}

	public LocalDate getBorrowedAt() {
		return borrowedAt;
	}

	public void setBorrowedAt(LocalDate borrowedAt) {
		this.borrowedAt = borrowedAt;
	}

	public LocalDate getRenderedAt() {
		return renderedAt;
	}

	public void setRenderedAt(LocalDate renderedAt) {
		this.renderedAt = renderedAt;
	}

	public String getBorrowerName() {
		return borrowerName;
	}

	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}

	public List<Emprunt> getEmprunts() {
		return emprunts;
	}

	public void addEmprunts(Emprunt emprunt) {
		this.emprunts.add(emprunt);
	}
	
	public void removeEmprunts(int index) {
		this.emprunts.remove(index);
	}
	
	
}
