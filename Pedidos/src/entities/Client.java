package entities;

import java.util.Date;

public class Client {
	private String name;
	private String email;
	private Date birthdate;
	
	public Client(String name, String email, Date aniersário) {
		this.name = name;
		this.email = email;
		this.birthdate = aniersário;
	}
	
	public Client() {
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getAniersário() {
		return birthdate;
	}

	public void setAniersário(Date aniersário) {
		this.birthdate = aniersário;
	}
	
	
}
