package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.AmministratoreDao;
import dao.AreaNaturaleDao;
import dao.ItinerarioDao;
import dao.RistoroDao;
import dao.RistoroDaoBean;
import dto.AreaNaturaleDTO;
import dto.RistoroDTO;
import dto.mapper.RistoroMapper;
import model.Amministratore;
import model.AreaNaturale;
import model.Itinerario;
import model.Ristoro;

@Stateless
public class RistoroController {
	@Inject
	private RistoroDao ristorodao;
	@Inject
	private AreaNaturaleDao areanaturaledao;
	@Inject
	private ItinerarioDao itinerariodao;
	@Inject
	private AmministratoreDao amministratoredao;
	@Inject
	private RistoroMapper ristoroMapper;
	
	public RistoroDTO getRistoro(long id) {
		return(ristoroMapper.convertToDTO(id));
	}
	
	public void createRistoro(Ristoro ristoro) {
		ristorodao.createRistoro(ristoro);
	}
	
	public void updateRistoro(long id,Ristoro ristoro) {
		Ristoro updateristoro =  ristorodao.getRistoro(id);
		updateristoro.setAddress(ristoro.getAddress());
		updateristoro.setCity(ristoro.getCity());
		updateristoro.setEmail(ristoro.getEmail());
		updateristoro.setLatitude(ristoro.getLatitude());
		updateristoro.setLongitude(ristoro.getLongitude());
		updateristoro.setOrganovalidante(ristoro.getOrganovalidante());
		updateristoro.setPhonenumber(ristoro.getPhonenumber());
		updateristoro.setProvince(ristoro.getProvince());
		updateristoro.setRistorotypology(ristoro.getRistorotypology());
		ristorodao.updateRistoro(updateristoro);
	}
	
	public void deleteRistoro(long id) {
		Ristoro ristoro = ristorodao.getRistoro(id);
		ristorodao.deleteRistoro(ristoro);
	}
	
	public List<RistoroDTO> getAllRistori(){
		List<Long> ristoroId = ristorodao.getAllRistori();
		List<RistoroDTO> ristori = new ArrayList<RistoroDTO>();
		for (long id: ristoroId) {
			ristori.add(ristoroMapper.convertToDTO(id));
		}
		return ristori;
	}
	
	public void associaArea(long idRistoro, long idArea) {
		Ristoro ristoro = ristorodao.getRistoro(idRistoro);
		System.out.println("ristoro trovato");
		AreaNaturale areanaturale = areanaturaledao.getAreaNaturale(idArea);
		ristorodao.associaArea(ristoro, areanaturale);
	}
	
	public void associaAmministratore(long idRisto, long idAmministratore) {
		Ristoro ristoro = ristorodao.getRistoro(idRisto);
		Amministratore amministratore = amministratoredao.getAmministratore(idAmministratore);
		ristorodao.associaAmministratore(ristoro, amministratore);
	}
	
	public void associaIti(long idRistoro, long idIti) {
		Ristoro ristoro = ristorodao.getRistoro(idRistoro);
		System.out.println("ristoro trovato");
		Itinerario itinerario = itinerariodao.getItinerario(idIti);
		ristorodao.associaIti(ristoro, itinerario);
	}
	
	public List<Long> getItiAssociati(long idRisto){
		return ristorodao.itinerariAssociati(idRisto);
	}
	
	
	
	
}
