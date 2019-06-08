package cn.wgh.json.pojo;

public class ExtendUser extends User {
	private String number;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "ExtendUser [number=" + number + ", getId()=" + getId() + ", getName()="
				+ getName() + "]";
	}

}
