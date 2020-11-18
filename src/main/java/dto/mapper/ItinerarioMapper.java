package dto.mapper;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.ItinerarioDao;
import dto.ItinerarioDTO;
import model.Itinerario;

@Stateless
public class ItinerarioMapper {
	
	@Inject
	ItinerarioDao itinerariodao;
	
	public ItinerarioDTO convertToDto(long id) {
		Itinerario itinerario = itinerariodao.getItinerario(id);
		ItinerarioDTO itiDto = new ItinerarioDTO();
		itiDto.setId(itinerario.getId());
		itiDto.setDescription(itinerario.getDescription());
		itiDto.setEndcity(itinerario.getEndcity());
		itiDto.setEndlatitude(itinerario.getEndlatitude());
		itiDto.setEndlongitude(itinerario.getEndlongitude());
		itiDto.setEndprovince(itinerario.getEndprovince());
		itiDto.setImage(itinerario.getImage());
		itiDto.setName(itinerario.getName());
		itiDto.setStartcity(itinerario.getStartcity());
		itiDto.setStartlatitude(itinerario.getStartlatitude());
		itiDto.setStartlongitude(itinerario.getStartlongitude());
		itiDto.setStartprovince(itinerario.getStartprovince());
		itiDto.setTrack(itinerario.getTrack());
		
		return itiDto;
	}
	
	public void transferToEntity(ItinerarioDTO itiDto, long id) {
		Itinerario itinerario = itinerariodao.getItinerario(id);
		itinerario.setDescription(itiDto.getDescription());
		itinerario.setEndcity(itiDto.getEndcity());
		itinerario.setEndlatitude(itiDto.getEndlatitude());
		itinerario.setEndlongitude(itiDto.getEndlongitude());
		itinerario.setEndprovince(itiDto.getEndprovince());
		itinerario.setImage(itiDto.getImage());
		itinerario.setName(itiDto.getName());
		itinerario.setStartcity(itiDto.getStartcity());
		itinerario.setStartlatitude(itiDto.getStartlatitude());
		itinerario.setStartlongitude(itiDto.getStartlongitude());
		itinerario.setStartprovince(itiDto.getStartprovince());
		itinerario.setTrack(itiDto.getTrack());
		
		
	}
	
	
	
	

}
