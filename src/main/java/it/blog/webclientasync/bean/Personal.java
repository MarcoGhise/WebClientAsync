package it.blog.webclientasync.bean;

public class Personal {
	private String name;
	private String surname;
	private String company;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "Personal [name=" + name + ", surname=" + surname + ", company=" + company + "]";
	}
}
