package dto.mapper;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.AreaNaturaleDao;
import dto.AreaNaturaleDTO;
import model.AreaNaturale;


@Stateless
public class AreaNaturaleMapper {
	
	@Inject
	private AreaNaturaleDao areanaturaledao;
	
	public AreaNaturaleDTO convertToDTO(long id) {
		AreaNaturale areanaturale = areanaturaledao.getAreaNaturale(id);
		AreaNaturaleDTO areaDto = new AreaNaturaleDTO();
		areaDto.setId(areanaturale.getId());
		areaDto.setName(areanaturale.getName());
		areaDto.setCity(areanaturale.getCity());
		areaDto.setDescription(areanaturale.getDescription());
		areaDto.setLatitude(areanaturale.getLatitude());
		areaDto.setLongitude(areanaturale.getLongitude());
		areaDto.setProvince(areanaturale.getProvince());
		areaDto.setAreanaturaletypology(areanaturale.getAreanaturaletypology());
		
		System.out.println("Nuovo name areaDTO: " + areaDto.getName());
		
		return areaDto;
	}
	
	public void transferToEntity(AreaNaturaleDTO areaDto, long id) {
		AreaNaturale areanaturale = areanaturaledao.getAreaNaturale(id);
		areanaturale.setName(areaDto.getName());
		areanaturale.setCity(areaDto.getCity());
		areanaturale.setDescription(areaDto.getDescription());
		areanaturale.setAreanaturaletypology(areaDto.getAreanaturaletypology());
		areanaturale.setLatitude(areaDto.getLatitude());
		areanaturale.setLongitude(areaDto.getLongitude());
		areanaturale.setProvince(areaDto.getProvince());
		
		
		
	}

}
