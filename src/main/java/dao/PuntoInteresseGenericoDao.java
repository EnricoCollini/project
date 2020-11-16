package dao;

import java.util.List;

import model.Amministratore;
import model.AreaNaturale;
import model.Itinerario;
import model.PuntoInteresseGenerico;

public interface PuntoInteresseGenericoDao {
	
	public PuntoInteresseGenerico getPuntoInteresseGenerico(long id);
	public void createPuntoInteresseGenerico(PuntoInteresseGenerico puntointeressegenerico);
	public void updatePuntoInteresseGenerico(PuntoInteresseGenerico puntointeressegenerico);
	public void deletePuntoInteresseGenerico(PuntoInteresseGenerico puntointeressegenerico);
	public List<PuntoInteresseGenerico> getPuntiInteresseGenerici();
	public void associaArea(PuntoInteresseGenerico punto, AreaNaturale areanaturale);
	public void associaIti(PuntoInteresseGenerico punto, Itinerario itinerario);
	public List<Long> itinerariAssociati(long idPunto);
	public void associaAmministratore(PuntoInteresseGenerico punto, Amministratore amministratore);
}
