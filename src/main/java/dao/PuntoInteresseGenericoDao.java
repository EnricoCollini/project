package dao;

import java.util.List;

import model.AreaNaturale;
import model.PuntoInteresseGenerico;

public interface PuntoInteresseGenericoDao {
	
	public PuntoInteresseGenerico getPuntoInteresseGenerico(long id);
	public void createPuntoInteresseGenerico(PuntoInteresseGenerico puntointeressegenerico);
	public void updatePuntoInteresseGenerico(PuntoInteresseGenerico puntointeressegenerico);
	public void deletePuntoInteresseGenerico(PuntoInteresseGenerico puntointeressegenerico);
	public List<PuntoInteresseGenerico> getPuntiInteresseGenerici();
	public void associaArea(PuntoInteresseGenerico punto, AreaNaturale areanaturale);
}
