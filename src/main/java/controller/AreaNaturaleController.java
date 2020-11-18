package controller;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.AmministratoreDao;
import dao.AreaNaturaleDao;
import dao.AreaNaturaleDaoBean;
import dto.AreaNaturaleDTO;
import dto.mapper.AreaNaturaleMapper;
import model.Amministratore;
import model.AreaNaturale;
import model.Itinerario;

@Stateless
public class AreaNaturaleController {

	
	@Inject
	private AreaNaturaleDao areanaturaledao;
	
	@Inject
	private AmministratoreDao amministratoredao;
	
	@Inject
	private AreaNaturaleMapper areaMapper;
	
	
	public AreaNaturaleDTO getAreaNaturale(long number) {
		return areaMapper.convertToDTO(number);

	}
	
	public void createAreaNaturale(AreaNaturale areanaturale) {
		areanaturaledao.createAreaNaturale(areanaturale);
	}
	
	public void updateAreaNaturale(long id,AreaNaturale areanaturale) {
		AreaNaturale updateareanaturale = areanaturaledao.getAreaNaturale(id);
    	updateareanaturale.setName(areanaturale.getName());
    	updateareanaturale.setCity(areanaturale.getCity());
    	updateareanaturale.setDescription(areanaturale.getDescription());
    	updateareanaturale.setImage(areanaturale.getImage());
    	updateareanaturale.setLatitude(areanaturale.getLatitude());
    	updateareanaturale.setLongitude(areanaturale.getLongitude());
    	updateareanaturale.setProvince(areanaturale.getProvince());
    	updateareanaturale.setAreanaturaletypology(areanaturale.getAreanaturaletypology());
		areanaturaledao.updateAreaNaturale(updateareanaturale);
	}
	
	public void deleteAreaNaturale(long number) {
		AreaNaturale deleteareanaturale = areanaturaledao.getAreaNaturale(number);
		areanaturaledao.deleteAreaNaturale(deleteareanaturale);
	}
	
	public void associaAmministratore(long idArea, long idAmministratore) {
		AreaNaturale areanaturale = areanaturaledao.getAreaNaturale(idArea);
		Amministratore amministratore = amministratoredao.getAmministratore(idAmministratore);
		areanaturaledao.associaAmministratore(areanaturale, amministratore);
	}
	
	public List<AreaNaturaleDTO> getAllAreeNaturalii(){
		List<Long> areeId = areanaturaledao.getAllAreeNaturalii();
		List<AreaNaturaleDTO> aree = new ArrayList<AreaNaturaleDTO>();
		for (long id: areeId) {
			aree.add(areaMapper.convertToDTO(id));
		}
		return aree;
	}
	
	public List<Long> getItiAssociati(long idArea){
		return areanaturaledao.itinerariAssociati(idArea);
	}
	
	public List<Long> getRistoAssociati(long idArea){
		return areanaturaledao.ristoriAssociati(idArea);
	}
	
	public List<Long> getPuntiInteresseAssociati(long idArea){
		return areanaturaledao.puntiInteresseAssociati(idArea);
	}
	
	public List<Long> getStruttureAssociate(long idArea){
		return areanaturaledao.struttureAssociate(idArea);
	}
	
}
