package br.com.desafio.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("DesafioPU");
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

}
