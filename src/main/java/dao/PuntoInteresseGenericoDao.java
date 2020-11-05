package dao;

import java.util.List;

import model.PuntoInteresseGenerico;

public interface PuntoInteresseGenericoDao {
	
	public PuntoInteresseGenerico getPuntoInteresseGenerico(long id);
	public void createPuntoInteresseGenerico(PuntoInteresseGenerico puntointeressegenerico);
	public void updatePuntoInteresseGenerico(PuntoInteresseGenerico puntointeressegenerico);
	public void deletePuntoInteresseGenerico(PuntoInteresseGenerico puntointeressegenerico);
	public List<PuntoInteresseGenerico> getPuntiInteresseGenerici();

}
