package dto.mapper;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.RistoroDao;
import dto.RistoroDTO;
import model.Ristoro;

@Stateless
public class RistoroMapper {
	
	@Inject
	RistoroDao ristorodao;
	
	public RistoroDTO convertToDTO(long id) {
		Ristoro ristoro = ristorodao.getRistoro(id);
		RistoroDTO ristoroDto = new RistoroDTO();
		ristoroDto.setId(ristoro.getId());
		ristoroDto.setName(ristoro.getName());
		ristoroDto.setCity(ristoro.getCity());
		ristoroDto.setLatitude(ristoro.getLatitude());
		ristoroDto.setLongitude(ristoro.getLongitude());
		ristoroDto.setProvince(ristoro.getProvince());
		ristoroDto.setPhonenumber(ristoro.getPhonenumber());
		ristoroDto.setOrganovalidante(ristoro.getOrganovalidante());
		ristoroDto.setAddress(ristoro.getAddress());
		ristoroDto.setEmail(ristoro.getEmail());
		ristoroDto.setRistorotypology(ristoro.getRistorotypology());
		
		
		return ristoroDto;
	}
	
	public void transferToEntity(RistoroDTO ristoroDto, long id) {
		Ristoro ristoro = ristorodao.getRistoro(id);
		ristoro.setId(ristoroDto.getId());
		ristoro.setName(ristoroDto.getName());
		ristoro.setCity(ristoroDto.getCity());
		ristoro.setLatitude(ristoroDto.getLatitude());
		ristoro.setLongitude(ristoroDto.getLongitude());
		ristoro.setProvince(ristoroDto.getProvince());
		ristoro.setPhonenumber(ristoroDto.getPhonenumber());
		ristoro.setOrganovalidante(ristoroDto.getOrganovalidante());
		ristoro.setAddress(ristoroDto.getAddress());
		ristoro.setEmail(ristoroDto.getEmail());
		ristoro.setRistorotypology(ristoroDto.getRistorotypology());
		
		
	}
	
	
	

}
