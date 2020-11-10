package controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.AreaNaturaleDao;
import dao.PuntoInteresseGenericoDao;
import model.AreaNaturale;
import model.PuntoInteresseGenerico;
import model.StrutturaRicettiva;

@Stateless
public class PuntoInteresseGenericoController {
	
	@Inject
	private PuntoInteresseGenericoDao puntointeressegenericodao;
	
	@Inject
	private AreaNaturaleDao areanaturaledao;
	
	public PuntoInteresseGenerico getPuntoInteresseGenrico(long id) {
		return puntointeressegenericodao.getPuntoInteresseGenerico(id);
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
	
	public List<PuntoInteresseGenerico> getAllPuntiInteresseGenerici(){
		return(puntointeressegenericodao.getPuntiInteresseGenerici());
	}
	
	public void associaArea(long idPunto, long idArea) {
		PuntoInteresseGenerico punto = puntointeressegenericodao.getPuntoInteresseGenerico(idPunto);
		AreaNaturale areanaturale = areanaturaledao.getAreaNaturale(idArea);
		puntointeressegenericodao.associaArea(punto, areanaturale);
	}
	
	

}
