package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import model.AreaNaturale;

@Entity
public class PuntoInteresseGenerico {
	
	private long id;
	private String name;
	private String description;
	private String city;
	private String province;
	private Float latitude;
	private Float longitude;
	private AreaNaturale areanaturale;
	private List<Itinerario> itinerari;
	
	
	@Id
	@GeneratedValue
	@Column(name="ID", nullable = false)
	@NotNull
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name="NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	
	@ManyToOne
	@JoinColumn(name = "AREANATURALE_ID")
	public AreaNaturale getAreanaturale() {
		return areanaturale;
	}
	public void setAreanaturale(AreaNaturale areanaturale) {
		this.areanaturale = areanaturale;
	}
	
	@ManyToMany
	@JoinTable(name = "puntointeressegenerico_itinerario",
	joinColumns = @JoinColumn(name = "puntointeressegenerico_id"),
	inverseJoinColumns = @JoinColumn(name = "itinerario_id"))
	public List<Itinerario> getItinerari() {
		return itinerari;
	}
	public void setItinerari(List<Itinerario> itinerari) {
		this.itinerari = itinerari;
	}
	
	public void aggiungiItinerario(Itinerario itinerario) {
		List<Itinerario> itinerari = this.getItinerari();
		itinerari.add(itinerario);
		this.setItinerari(itinerari);
	}

}
