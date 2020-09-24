package dao;
import java.util.List;
import java.util.UUID;

import model.AreaNaturale;

public interface AreaNaturaleDao {
	public AreaNaturale getAreaNaturale(UUID uuid);
	public void createAreaNaturale(AreaNaturale areanaturale);
	public void updateAreaNaturale(AreaNaturale areanaturale);
	public void deleteAreaNaturale(AreaNaturale areanaturale);
	public List<AreaNaturale> getAllAreeNaturalii();
}
