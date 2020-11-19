package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Amministratore {
	
	private long id;
	private String email;
	private String password;
	private String jwt;
	private List<Ristoro> ristori;
	private List<StrutturaRicettiva> strutturericettive;
	private List<PuntoInteresseGenerico> puntiinteresse;
	private List<Itinerario> itinerari;
	private List<AreaNaturale> areenaturali;
	
	public Amministratore() {}
	
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

	@Column(name="EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="PASSWORD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@OneToMany(mappedBy = "amministratore")
	public List<Ristoro> getRistori() {
		return ristori;
	}

	public void setRistori(List<Ristoro> ristori) {
		this.ristori = ristori;
	}

	@OneToMany(mappedBy = "amministratore")
	public List<StrutturaRicettiva> getStrutturaricettiva() {
		return strutturericettive;
	}

	public void setStrutturaricettiva(List<StrutturaRicettiva> strutturericettive) {
		this.strutturericettive = strutturericettive;
	}

	@OneToMany(mappedBy = "amministratore")
	public List<PuntoInteresseGenerico> getPuntointeressegenerico() {
		return puntiinteresse;
	}

	public void setPuntointeressegenerico(List<PuntoInteresseGenerico> puntiinteresse) {
		this.puntiinteresse = puntiinteresse;
	}

	@OneToMany(mappedBy = "amministratore")
	public List<Itinerario> getItinerari() {
		return itinerari;
	}

	
	public void setItinerari(List<Itinerario> itinerari) {
		this.itinerari = itinerari;
	}

	@OneToMany(mappedBy = "amministratore")
	public List<AreaNaturale> getAreenaturali() {
		return areenaturali;
	}

	public void setAreenaturali(List<AreaNaturale> areenaturali) {
		this.areenaturali = areenaturali;
	}

	@Column(name="JWT")
	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}



}
