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
import static model.AreaNaturaleTypology.*;

@Entity
public class AreaNaturale{

	private UUID uuid;
	private String name;
	private String city;
	private String province;
	private Float latitude;
	private Float longitude;
	private String description;
	private AreaNaturaleTypology areanaturaletypology;
	private byte[] image;
	
	//TODO:  add Image attribute;
	@Id
	@GeneratedValue
	@Column(name="ID", nullable = false)
	@NotNull
	public UUID getId() {
		return uuid;
	}
	
	public void setId(UUID uuid) {
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


	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

	@Column(name="AREANATURALETYPOLOGY")
	@Enumerated(EnumType.STRING)
	public AreaNaturaleTypology getAreanaturaletypology() {
		return areanaturaletypology;
	}

	public void setAreanaturaletypology(AreaNaturaleTypology areanaturaletypology) {
		this.areanaturaletypology = areanaturaletypology;
	}

    @Lob
    @Column(name="IMAGE")
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

}