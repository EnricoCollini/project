package dto;

import model.AreaNaturaleTypology;

public class AreaNaturaleDTO {
	
	private long id;
	private String name;
	private String city;
	private String province;
	private Float latitude;
	private Float longitude;
	private String description;
	private AreaNaturaleTypology areanaturaletypology;

	public AreaNaturaleDTO () {
		
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public AreaNaturaleTypology getAreanaturaletypology() {
		return areanaturaletypology;
	}
	public void setAreanaturaletypology(AreaNaturaleTypology areanaturaletypology) {
		this.areanaturaletypology = areanaturaletypology;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

}
