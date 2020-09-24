package controller;
import java.util.List;
import java.util.UUID;

import dao.AreaNaturaleDaoBean;
import model.AreaNaturale;

public class AreaNaturaleController {
	private AreaNaturaleDaoBean areanaturaledao;
	
	public AreaNaturale getAreaNaturale(UUID uuid) {
		return areanaturaledao.getAreaNaturale(uuid);
	}
	
	public void createAreaNaturale(AreaNaturale areanaturale) {
		areanaturaledao.createAreaNaturale(areanaturale);
	}
	
	public void updateAreaNaturale(AreaNaturale areanaturale) {
		UUID uuid = areanaturale.getUuid();
		AreaNaturale updateareanaturale = areanaturaledao.getAreaNaturale(uuid);
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
	
	public void deleteAreaNaturale(UUID uuid) {
		AreaNaturale deleteareanaturale = areanaturaledao.getAreaNaturale(uuid);
		areanaturaledao.deleteAreaNaturale(deleteareanaturale);
	}
	
	public List<AreaNaturale> getAllAreeNaturalii(){
		return(areanaturaledao.getAllAreeNaturalii());
	}
}
