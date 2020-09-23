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
import javax.xml.*;

@Entity
public class Itinerario {
	
	private UUID uuid;
	private String name;
	private String startcity;
	private String startprovince;
	private Float startlatitude;
	private Float startlongitude;
	private String endcity;
	private String endprovince;
	private Float endlatitude;
	private Float endlongitude;
	private String description;
	private byte[] image;
	private String gpx;
	//TODO: add gpx file;
	
	
	

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

	
	@Column(name="STARTCITY")
	public String getStartcity() {
		return startcity;
	}

	public void setStartcity(String startcity) {
		this.startcity = startcity;
	}

	
	@Column(name="STARTPROVINCE")
	public String getStartprovince() {
		return startprovince;
	}

	public void setStartprovince(String startprovince) {
		this.startprovince = startprovince;
	}

	
	@Column(name="STARTLATITUDE")
	public Float getStartlatitude() {
		return startlatitude;
	}

	public void setStartlatitude(Float startlatitude) {
		this.startlatitude = startlatitude;
	}

	
	@Column(name="STARTLONGITUDE")
	public Float getStartlongitude() {
		return startlongitude;
	}

	public void setStartlongitude(Float startlongitude) {
		this.startlongitude = startlongitude;
	}

	
	@Column(name="ENDCITY")
	public String getEndcity() {
		return endcity;
	}

	public void setEndcity(String endcity) {
		this.endcity = endcity;
	}

	
	@Column(name="ENDPROVINCE")
	public String getEndprovince() {
		return endprovince;
	}

	public void setEndprovince(String endprovince) {
		this.endprovince = endprovince;
	}

	
	@Column(name="ENDLATITUDE")
	public Float getEndlatitude() {
		return endlatitude;
	}

	public void setEndlatitude(Float endlatitude) {
		this.endlatitude = endlatitude;
	}

	
	@Column(name="ENDLONGITUDE")
	public Float getEndlongitude() {
		return endlongitude;
	}

	public void setEndlongitude(Float endlongitude) {
		this.endlongitude = endlongitude;
	}

	
	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	@Lob
	@Column(name="IMAGE")
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Column(name="GPX")
	public String getGpx() {
		return gpx;
	}

	public void setGpx(String gpx) {
		this.gpx = gpx;
	}
	
}
