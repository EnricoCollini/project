package dto.mapper;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.PuntoInteresseGenericoDao;
import dto.PuntoInteresseGenericoDTO;
import model.PuntoInteresseGenerico;

@Stateless
public class PuntoInteresseGenericoMapper {
	
	@Inject
	PuntoInteresseGenericoDao puntodao;
	
	public PuntoInteresseGenericoDTO convertToDTO(long id) {
		PuntoInteresseGenerico punto = puntodao.getPuntoInteresseGenerico(id);
		PuntoInteresseGenericoDTO puntoDto = new PuntoInteresseGenericoDTO();
		puntoDto.setId(punto.getId());
		puntoDto.setCity(punto.getCity());
		puntoDto.setDescription(punto.getDescription());
		puntoDto.setLatitude(punto.getLatitude());
		puntoDto.setLongitude(punto.getLongitude());
		puntoDto.setProvince(punto.getProvince());
		puntoDto.setName(punto.getName());
		
		return puntoDto;
	}
	
	public void transferToEntity(PuntoInteresseGenericoDTO puntoDto, long id) {
		PuntoInteresseGenerico punto = puntodao.getPuntoInteresseGenerico(id);
		punto.setCity(puntoDto.getCity());
		punto.setDescription(puntoDto.getDescription());
		punto.setLatitude(puntoDto.getLatitude());
		punto.setLongitude(puntoDto.getLongitude());
		punto.setProvince(puntoDto.getProvince());
		punto.setName(puntoDto.getName());
	}
	
	

}
