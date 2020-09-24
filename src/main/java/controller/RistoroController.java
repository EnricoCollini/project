package controller;

import java.util.List;

import dao.RistoroDaoBean;
import model.Ristoro;

public class RistoroController {
	private RistoroDaoBean ristorodao;
	
	public Ristoro getRistoro(String uuid) {
		return(ristorodao.getRistoro(uuid));
	}
	
	public void createRistoro(Ristoro ristoro) {
		ristorodao.createRistoro(ristoro);
	}
	
	public void updateRistoro(Ristoro ristoro) {
		ristorodao.updateRistoro(ristoro);
	}
	public void deleteRistoro(Ristoro ristoro) {
		ristorodao.deleteRistoro(ristoro);
	}
	public List<Ristoro> getAllRistori(){
		return(ristorodao.getAllRistori());
	}
	
	
}
