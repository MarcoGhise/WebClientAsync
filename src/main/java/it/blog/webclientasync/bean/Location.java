package it.blog.webclientasync.bean;

public class Location {

	private String city;
	private String address;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Location [city=" + city + ", address=" + address + "]";
	}
}
