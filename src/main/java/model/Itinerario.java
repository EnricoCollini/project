package model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import java.util.List;
import java.util.UUID;

import javax.json.Json;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import model.AreaNaturale;

@Entity
public class Itinerario {
	
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
	private List<AreaNaturale> areenaturali;
	private List<PuntoInteresseGenerico> puntiinteressegenerici;
	private List<Ristoro> ristori;
	private List<StrutturaRicettiva> strutturericettive;
	//TODO: add gpx file;
	
	
	

	@Id
	@GeneratedValue
	@Column(name="ID", nullable = false)
	@NotNull
	public long getId() {
		return id;
	}
	
	public void setId(long id ) {
		this.id = id;
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

	@Column(name="TRACK" ,columnDefinition="VARCHAR(4000)")
	public String getTrack() {
		return track;
	}

	public void setTrack(String track) {
		this.track = track;
	}

	@ManyToMany
	@JoinTable(name = "itinerario_areanaturale",
	joinColumns = @JoinColumn(name = "itinerario_id"),
	inverseJoinColumns = @JoinColumn(name = "areanaturale_id"))
	public List<AreaNaturale> getAreenaturali() {
		return areenaturali;
	}

	public void setAreenaturali(List<AreaNaturale> areenaturali) {
		this.areenaturali = areenaturali;
	}

	@ManyToMany(mappedBy = "itinerari")
	public List<PuntoInteresseGenerico> getPuntiinteressegenerici() {
		return puntiinteressegenerici;
	}

	public void setPuntiinteressegenerici(List<PuntoInteresseGenerico> puntiinteressegenerici) {
		this.puntiinteressegenerici = puntiinteressegenerici;
	}

	@ManyToMany(mappedBy = "itinerari")
	public List<Ristoro> getRistori() {
		return ristori;
	}

	public void setRistori(List<Ristoro> ristori) {
		this.ristori = ristori;
	}

	@ManyToMany(mappedBy = "itinerari")
	public List<StrutturaRicettiva> getStrutturericettive() {
		return strutturericettive;
	}

	public void setStrutturericettive(List<StrutturaRicettiva> strutturericettive) {
		this.strutturericettive = strutturericettive;
	}
	
	public void aggiungiArea(AreaNaturale areanaturale) {
		List<AreaNaturale> areenaturali = this.getAreenaturali();
		areenaturali.add(areanaturale);
		this.setAreenaturali(areenaturali);
	}
	
}
