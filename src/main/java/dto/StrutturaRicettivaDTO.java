package dto;

import model.StrutturaRicettivaTypology;

public class StrutturaRicettivaDTO {
	
	private long id;
	private String name;
	private String city;
	private String province;
	private Float latitude;
	private Float longitude;
	private String phonenumber;
	private  String address;
	private String email;
	private StrutturaRicettivaTypology strutturaricettivatipology;
	
	public StrutturaRicettivaDTO() {}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public Float getLatitude() {
		return latitude;
	}
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	public Float getLongitude() {
		return longitude;
	}
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public StrutturaRicettivaTypology getStrutturaricettivatipology() {
		return strutturaricettivatipology;
	}
	public void setStrutturaricettivatipology(StrutturaRicettivaTypology strutturaricettivatipology) {
		this.strutturaricettivatipology = strutturaricettivatipology;
	}

}
