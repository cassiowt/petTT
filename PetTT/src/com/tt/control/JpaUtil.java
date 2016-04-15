package com.tt.control;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tt.model.Dono;

public class JpaUtil {
	private static  EntityManager em;
	private static  EntityManagerFactory factory;

	static {
		try {
			 factory = Persistence.createEntityManagerFactory("PetTT");
			 em = factory.createEntityManager();
			 
		} catch (RuntimeException e) {
			System.out.println("TRACE____________________________:");
			e.printStackTrace();
		}
	}

	public static EntityManager getFactory() {
		return em;
	}

	
	public static void main(String[] args) {
		getFactory().getTransaction().begin();
		
		Dono dono = new Dono("DONO #1", "TELEFONE #1", "ENDERECO #1", null);
		
		
		
		
		
		getFactory().getTransaction().commit();
		getFactory().close();
	}
}
