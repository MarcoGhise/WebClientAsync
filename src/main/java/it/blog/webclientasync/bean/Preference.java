package it.blog.webclientasync.bean;

public class Preference {

	private String openinghours;
	private String accessible;
	public String getOpeninghours() {
		return openinghours;
	}
	public void setOpeninghours(String openinghours) {
		this.openinghours = openinghours;
	}
	public String getAccessible() {
		return accessible;
	}
	public void setAccessible(String accessible) {
		this.accessible = accessible;
	}
	@Override
	public String toString() {
		return "Preference [openinghours=" + openinghours + ", accessible=" + accessible + "]";
	}

}
