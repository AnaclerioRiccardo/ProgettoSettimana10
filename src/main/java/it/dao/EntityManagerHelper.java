package it.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerHelper {
	
	public static EntityManagerFactory emf = null;
	
	//Getter Lazy
	public static EntityManagerFactory getEmf() {
		if(emf==null)
			emf= Persistence.createEntityManagerFactory("piattaformafilmPS");
		return emf;
	}

	//Metodi
	public static EntityManager getEntityManager() {
		return getEmf().createEntityManager();
	}

}
