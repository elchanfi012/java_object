package object.model;

import java.util.Date;

public class Member {
	
	private Integer id;
	private String lastName;
	private String firstName;
	private Date birthAt;
	
	public Member(Integer id, String lastName, String firstName) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthAt = new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getBirthAt() {
		return birthAt;
	}

	public void setBirthAt(Date birthAt) {
		this.birthAt = birthAt;
	}


	@Override
	public String toString() {
		return "Member {id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + "}";
	}

	
	
	

}
