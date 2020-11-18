package dto;

public class ItinerarioDTO {
	
	private long id;
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
	private String track;
	
	public ItinerarioDTO() {}
	
	
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
	public String getStartcity() {
		return startcity;
	}
	public void setStartcity(String startcity) {
		this.startcity = startcity;
	}
	public String getStartprovince() {
		return startprovince;
	}
	public void setStartprovince(String startprovince) {
		this.startprovince = startprovince;
	}
	public Float getStartlatitude() {
		return startlatitude;
	}
	public void setStartlatitude(Float startlatitude) {
		this.startlatitude = startlatitude;
	}
	public Float getStartlongitude() {
		return startlongitude;
	}
	public void setStartlongitude(Float startlongitude) {
		this.startlongitude = startlongitude;
	}
	public String getEndcity() {
		return endcity;
	}
	public void setEndcity(String endcity) {
		this.endcity = endcity;
	}
	public String getEndprovince() {
		return endprovince;
	}
	public void setEndprovince(String endprovince) {
		this.endprovince = endprovince;
	}
	public Float getEndlatitude() {
		return endlatitude;
	}
	public void setEndlatitude(Float endlatitude) {
		this.endlatitude = endlatitude;
	}
	public Float getEndlongitude() {
		return endlongitude;
	}
	public void setEndlongitude(Float endlongitude) {
		this.endlongitude = endlongitude;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getTrack() {
		return track;
	}
	public void setTrack(String track) {
		this.track = track;
	}
	
	

}
