package com.tt.dao;

import javax.persistence.EntityManager;

import com.tt.control.JpaUtil;
import com.tt.model.Animal;

public class AnimalDAO {

	static EntityManager fabrica = JpaUtil.getFactory();

	public boolean cadastrar(Animal animal) {
		boolean ok = false;

		if (animal != null) {
			fabrica.getTransaction().begin();
			fabrica.persist(animal);
			fabrica.flush();
			fabrica.getTransaction().commit();
			fabrica.close();
			ok = true;
		}
		return ok;

	}
}