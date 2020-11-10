package model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.mysql.cj.jdbc.Clob;


import static model.AreaNaturaleTypology.*;
import model.Ristoro;
import model.StrutturaRicettiva;
import model.PuntoInteresseGenerico;
import model.Itinerario;

@Entity
public class AreaNaturale{

	private long id;
	private String name;
	private String city;
	private String province;
	private Float latitude;
	private Float longitude;
	private String description;
	private AreaNaturaleTypology areanaturaletypology;
	private byte[] image;
	private List<Ristoro> ristori;
	private List<StrutturaRicettiva> strutturaricettiva;
	private List<PuntoInteresseGenerico> puntointeressegenerico;
	private List<Itinerario> itinerari;
	
	
	
	
	
	public AreaNaturale() {}
	
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


	@Column(name="DESCRIPTION",columnDefinition="VARCHAR(4000)")
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
	

	@OneToMany(mappedBy = "areanaturale")
	public List<Ristoro> getRistori() {
		return ristori;
	}

	public void setRistori(List<Ristoro> ristori) {
		this.ristori = ristori;
	}

	@OneToMany(mappedBy = "areanaturale")
	public List<StrutturaRicettiva> getStrutturaricettiva() {
		return strutturaricettiva;
	}

	public void setStrutturaricettiva(List<StrutturaRicettiva> strutturaricettiva) {
		this.strutturaricettiva = strutturaricettiva;
	}

	@OneToMany(mappedBy = "areanaturale")
	public List<PuntoInteresseGenerico> getPuntointeressegenerico() {
		return puntointeressegenerico;
	}

	public void setPuntointeressegenerico(List<PuntoInteresseGenerico> puntointeressegenerico) {
		this.puntointeressegenerico = puntointeressegenerico;
	}

	@ManyToMany(mappedBy = "areenaturali")
	public List<Itinerario> getItinerari() {
		return itinerari;
	}

	public void setItinerari(List<Itinerario> itinerari) {
		this.itinerari = itinerari;
	}
	
	
}