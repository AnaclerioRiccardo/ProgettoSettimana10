package it.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.security.crypto.bcrypt.BCrypt;

import it.entity.Film;

public class FilmDaoImp implements FilmDao {
	
	//Attributi
	EntityManager em = null;

	//Metodi CRUD
	public void salva(Film f) {
		try {
			getEm().getTransaction().begin();	//Inizio la transazione
			em.persist(filmIncassoCrypt(f));
		} catch (Exception e) {
			em.getTransaction().rollback();	//Faccio un rollback in caso qualcosa vada storto
		} finally {
			em.getTransaction().commit();	//faccio un commit a prescindere se l'operazione vada bene o no
		}
	}

	public void aggiorna(Film f) throws Exception {
		if(trova(f.getId())==null) {
			throw new Exception("Film non trovato");
		}
		try {
			getEm().getTransaction().begin();	//Inizio la transazione
			em.merge(filmIncassoCrypt(f));
		} catch (Exception e) {
			em.getTransaction().rollback();	//Faccio un rollback in caso qualcosa vada storto
		} finally {
			em.getTransaction().commit();	//faccio un commit a prescindere se l'operazione vada bene o no
		}
	}

	public void cancella(Integer id) {
		try {
			getEm().getTransaction().begin();	//Inizio la transazione
			em.remove(trova(id));
		} catch (Exception e) {
			em.getTransaction().rollback();	//Faccio un rollback in caso qualcosa vada storto
		} finally {
			em.getTransaction().commit();	//faccio un commit a prescindere se l'operazione vada bene o no
		}
	}

	public Film trova(Integer id) {
		return getEm().find(Film.class, id);
	}

	public List<Film> trovaTutti() {
		return getEm().createNamedQuery("film.getAll").getResultList();
	}
	
	/**
	 *  Restituisce la lista di tutti i film fatti da quel regista
	 * 
	 *  @author  Riccardo Anaclerio
	 *  @param  regista regista da ricercare
	 *  @return  lista di Film fatti da quel regista	 
	 */
	public List<Film> trovaByRegista(String regista) {
		Query q = getEm().createNamedQuery("film.selectByRegista");
		q.setParameter(1, regista);
		return q.getResultList();
	}
	
	//Restituisco il film con l'incasso criptato
	private Film filmIncassoCrypt(Film f) {
		String incassoCryptato = BCrypt.hashpw(f.getIncasso(), BCrypt.gensalt());
		f.setIncasso(incassoCryptato);
		return f;
	}
	
	//Getter lazy
	public EntityManager getEm() {
		if(em==null)
			em = EntityManagerHelper.getEntityManager();
		return em;
	}

}
