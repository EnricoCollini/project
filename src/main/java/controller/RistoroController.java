package controller;

import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.RistoroDao;
import dao.RistoroDaoBean;
import model.AreaNaturale;
import model.Ristoro;

@Stateless
public class RistoroController {
	@Inject
	private RistoroDao ristorodao;
	
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
