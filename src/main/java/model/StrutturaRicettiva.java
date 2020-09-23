package model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

import model.StrutturaRicettivaTypology.*;

@Entity
public class StrutturaRicettiva {
	private UUID uuid;
	private String name;
	private String city;
	private String province;
	private Float latitude;
	private Float longitude;
	private String phonenumber;
	private  String address;
	private String email;
	private StrutturaRicettivaTypology strutturaricettivatipology;

	
	@Id
	@GeneratedValue
	@Column(name="ID", nullable = false)
	@NotNull
	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	
	@Column(name="NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	@Column(name="CITY")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	

	@Column(name="PROVINCE")
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	

	@Column(name="LATITUDE")
	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}


	@Column(name="LONGITUDE")
	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}


	@Column(name="PHONENUMBER")
	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}


	@Column(name="ADDRESS")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

	@Column(name="EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
		
	
	@Column(name="STRUTTURARICETTIVATYPOLOGY")
	@Enumerated(EnumType.STRING)
	public StrutturaRicettivaTypology getStrutturaricettivatipology() {
		return strutturaricettivatipology;
	}

	public void setStrutturaricettivatipology(StrutturaRicettivaTypology strutturaricettivatipology) {
		this.strutturaricettivatipology = strutturaricettivatipology;
	}
}
