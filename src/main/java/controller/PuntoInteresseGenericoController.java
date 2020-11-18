package controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.AmministratoreDao;
import dao.AreaNaturaleDao;
import dao.ItinerarioDao;
import dao.PuntoInteresseGenericoDao;
import dto.PuntoInteresseGenericoDTO;
import dto.RistoroDTO;
import dto.mapper.PuntoInteresseGenericoMapper;
import model.Amministratore;
import model.AreaNaturale;
import model.Itinerario;
import model.PuntoInteresseGenerico;
import model.Ristoro;
import model.StrutturaRicettiva;

@Stateless
public class PuntoInteresseGenericoController {
	
	@Inject
	private PuntoInteresseGenericoDao puntointeressegenericodao;
	
	@Inject
	private AreaNaturaleDao areanaturaledao;
	
	@Inject
	private ItinerarioDao itinerariodao;
	
	@Inject
	private AmministratoreDao amministratoredao;
	
	@Inject
	private PuntoInteresseGenericoMapper puntoMapper;
	
	public PuntoInteresseGenericoDTO getPuntoInteresseGenrico(long id) {
		return(puntoMapper.convertToDTO(id));
	}
	
	public void createPuntoInteresseGenerico(PuntoInteresseGenerico puntointeressegenerico) {
		puntointeressegenericodao.createPuntoInteresseGenerico(puntointeressegenerico);
	}
	
	public void updatePuntoInteresseGenerico(long id, PuntoInteresseGenerico puntointeressegenerico) {
		PuntoInteresseGenerico puntoUpdate = puntointeressegenericodao.getPuntoInteresseGenerico(id);
		puntoUpdate.setName(puntointeressegenerico.getName());
		puntoUpdate.setCity(puntointeressegenerico.getCity());
		puntoUpdate.setDescription(puntointeressegenerico.getDescription());
		puntoUpdate.setLatitude(puntointeressegenerico.getLatitude());
		puntoUpdate.setLongitude(puntointeressegenerico.getLongitude());
		puntoUpdate.setProvince(puntointeressegenerico.getProvince());
		puntointeressegenericodao.updatePuntoInteresseGenerico(puntoUpdate);
	}
	
	public void deletePuntoInteresseGenerico(long id) {
		PuntoInteresseGenerico puntointeressegenerico = puntointeressegenericodao.getPuntoInteresseGenerico(id);
		puntointeressegenericodao.deletePuntoInteresseGenerico(puntointeressegenerico);
	}
	
	public List<PuntoInteresseGenericoDTO> getAllPuntiInteresseGenerici(){
		List<Long> puntoId = puntointeressegenericodao.getPuntiInteresseGenerici();
		List<PuntoInteresseGenericoDTO> punti = new ArrayList<PuntoInteresseGenericoDTO>();
		for (long id: puntoId) {
			punti.add(puntoMapper.convertToDTO(id));
		}
		return punti;
	}
	
	public void associaArea(long idPunto, long idArea) {
		PuntoInteresseGenerico punto = puntointeressegenericodao.getPuntoInteresseGenerico(idPunto);
		AreaNaturale areanaturale = areanaturaledao.getAreaNaturale(idArea);
		puntointeressegenericodao.associaArea(punto, areanaturale);
	}
	
	public void associaIti(long idPunto, long idIti) {
		PuntoInteresseGenerico punto = puntointeressegenericodao.getPuntoInteresseGenerico(idPunto);
		Itinerario itinerario = itinerariodao.getItinerario(idIti);
		puntointeressegenericodao.associaIti(punto, itinerario);
	}
	
	public void associaAmministratore(long idPunto, long idAmministratore) {
		PuntoInteresseGenerico punto = puntointeressegenericodao.getPuntoInteresseGenerico(idPunto);
		Amministratore amministratore = amministratoredao.getAmministratore(idAmministratore);
		puntointeressegenericodao.associaAmministratore(punto, amministratore);
	}
	
	public List<Long> getItiAssociati(long idPunto){
		return puntointeressegenericodao.itinerariAssociati(idPunto);
	}
	
	

}
