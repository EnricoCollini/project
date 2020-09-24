package controller;

import java.util.List;
import java.util.UUID;

import dao.RistoroDaoBean;
import model.AreaNaturale;
import model.Ristoro;

public class RistoroController {
	private RistoroDaoBean ristorodao;
	
	public Ristoro getRistoro(UUID uuid) {
		return(ristorodao.getRistoro(uuid));
	}
	
	public void createRistoro(Ristoro ristoro) {
		ristorodao.createRistoro(ristoro);
	}
	
	public void updateRistoro(UUID uuid,Ristoro ristoro) {
		Ristoro updateristoro =  ristorodao.getRistoro(uuid);
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
	
	public void deleteRistoro(UUID uuid) {
		Ristoro ristoro = ristorodao.getRistoro(uuid);
		ristorodao.deleteRistoro(ristoro);
	}
	
	public List<Ristoro> getAllRistori(){
		return(ristorodao.getAllRistori());
	}
	
	
}