package dao;

import java.util.List;
import java.util.UUID;

import model.Ristoro;

public interface RistoroDao {
	public Ristoro getRistoro(long id);
	public void createRistoro(Ristoro ristoro);
	public void updateRistoro(Ristoro ristoro);
	public void deleteRistoro(Ristoro ristoro);
	public List<Ristoro> getAllRistori();

}
