package it.blog.webclientasync.bean;

public class CustomerProfile {

	private Contact contact;
	private Location location;
	private Personal personal;
	private Preference preference;
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Personal getPersonal() {
		return personal;
	}
	public void setPersonal(Personal personal) {
		this.personal = personal;
	}
	public Preference getPreference() {
		return preference;
	}
	public void setPreference(Preference preference) {
		this.preference = preference;
	}
	@Override
	public String toString() {
		return "CustomerProfile [contact=" + contact + ", location=" + location + ", personal=" + personal
				+ ", preference=" + preference + "]";
	}
}
