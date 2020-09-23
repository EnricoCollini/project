package dao;
import java.util.List;
import model.AreaNaturale;

public interface AreaNaturaleDao {
	public AreaNaturale getAreaNaturale(String uuid);
	public void createAreaNaturale(AreaNaturale areanaturale);
	public void updateAreaNaturale(AreaNaturale areanaturale);
	public void deleteAreaNaturale(AreaNaturale areanaturale);
	public List<AreaNaturale> getAllAreeNaturalii();
}
