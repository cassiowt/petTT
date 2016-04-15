package com.tt.dao;

import java.util.Collection;

import javax.management.Query;
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

	@SuppressWarnings("unchecked")
	public Collection<Animal> listar() {

		Query query = (Query) fabrica.createNamedQuery("queryAnimais");
		return ((javax.persistence.Query) query).getResultList();
	}

	public boolean remover(Animal animal) {

		if (animal != null) {

			fabrica.getTransaction().begin();
			Animal animalDB = fabrica.find(Animal.class, animal.getId());
			
			if (animalDB != null) {
				fabrica.remove(animalDB);
			}

			fabrica.getTransaction().commit();
			fabrica.close();
			return true;
		}

		return false;
	}
}