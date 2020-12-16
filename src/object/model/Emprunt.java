package object.model;


import java.io.Serializable;
import java.time.LocalDateTime;


public class Emprunt implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private LocalDateTime borrowedAt;
	private LocalDateTime renderedAt;
	private String borrowerName;
	
	

	public Emprunt(LocalDateTime borrowedAt, LocalDateTime renderedAt, String borrowerName) {
		this.borrowedAt = borrowedAt;
		this.renderedAt = renderedAt;
		this.borrowerName = borrowerName;
	}

	public LocalDateTime getBorrowedAt() {
		return borrowedAt;
	}

	public void setBorrowedAt(LocalDateTime borrowedAt) {
		this.borrowedAt = borrowedAt;
	}

	public LocalDateTime getRenderedAt() {
		return renderedAt;
	}

	public void setRenderedAt(LocalDateTime renderedAt) {
		this.renderedAt = renderedAt;
	}

	public String getBorrowerName() {
		return borrowerName;
	}

	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}

	@Override
	public String toString() {
		return "Emprunt {borrowedAt=" + borrowedAt 
				+ ", renderedAt=" + renderedAt 
				+ ", borrowerName=" + borrowerName + "}";
	}

	
	
	
}
