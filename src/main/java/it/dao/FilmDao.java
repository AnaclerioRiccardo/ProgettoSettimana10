package it.dao;

import java.util.List;

import it.entity.Film;


public interface FilmDao {
	
	public void salva(Film f);
	public void aggiorna(Film f) throws Exception;
	public void cancella(Integer id);
	public Film trova(Integer id);
	public List<Film> trovaTutti();
	public List<Film> trovaByRegista(String regista);

}
