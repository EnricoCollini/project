package dto.mapper;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.StrutturaRicettivaDao;
import dto.StrutturaRicettivaDTO;
import model.StrutturaRicettiva;

@Stateless
public class StrutturaRicettivaMapper {
	
	@Inject
	StrutturaRicettivaDao strutturaricettivadao;
	
	public StrutturaRicettivaDTO convertToDto(long id) {
		StrutturaRicettiva struttura = strutturaricettivadao.getStrutturaRicettiva(id);
		StrutturaRicettivaDTO strutturaDto = new StrutturaRicettivaDTO();
		strutturaDto.setId(struttura.getId());
		strutturaDto.setName(struttura.getName());
		strutturaDto.setCity(struttura.getCity());
		strutturaDto.setLatitude(struttura.getLatitude());
		strutturaDto.setLongitude(struttura.getLongitude());
		strutturaDto.setProvince(struttura.getProvince());
		strutturaDto.setPhonenumber(struttura.getPhonenumber());
		strutturaDto.setAddress(struttura.getAddress());
		strutturaDto.setEmail(struttura.getEmail());
		strutturaDto.setStrutturaricettivatipology(struttura.getStrutturaricettivatipology());
		
		return strutturaDto;	
		
	}
	
	public void transferToEntity(StrutturaRicettivaDTO strutturaDto, long id) {
		StrutturaRicettiva struttura = strutturaricettivadao.getStrutturaRicettiva(id);
		struttura.setName(strutturaDto.getName());
		struttura.setCity(strutturaDto.getCity());
		struttura.setLatitude(strutturaDto.getLatitude());
		struttura.setLongitude(strutturaDto.getLongitude());
		struttura.setProvince(strutturaDto.getProvince());
		struttura.setPhonenumber(strutturaDto.getPhonenumber());
		struttura.setAddress(strutturaDto.getAddress());
		struttura.setEmail(strutturaDto.getEmail());
		struttura.setStrutturaricettivatipology(strutturaDto.getStrutturaricettivatipology());
		
	}

}
