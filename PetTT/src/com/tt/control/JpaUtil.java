package com.tt.control;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tt.model.Animal;
import com.tt.model.Dono;
import com.tt.model.Raca;
import com.tt.model.TipoAnimal;

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
		
		Raca raca = new Raca("Labrador");		
		Animal animal1 = new Animal("ANIMAL #1", TipoAnimal.CACHORRO, raca, "CARACTERISTICAS");
		Animal animal2 = new Animal("ANIMAL #2", TipoAnimal.CACHORRO, raca, "CARACTERISTICAS");
		Animal animal3 = new Animal("ANIMAL #3", TipoAnimal.CACHORRO, raca, "CARACTERISTICAS");
		
		Collection<Animal> animais = new ArrayList<Animal>();
		animais.add(animal1);
		animais.add(animal2);
		animais.add(animal3);
		
		Dono dono = new Dono("DONO #1", "TELEFONE #1", "ENDERECO #1", animais);
		
		getFactory().persist(dono);
		
		System.out.println("__________________________OK______________________________");
		
		getFactory().getTransaction().commit();
		getFactory().close();
	}
}
