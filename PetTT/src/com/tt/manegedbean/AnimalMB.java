package com.tt.manegedbean;

import java.util.ArrayList;
import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import com.tt.dao.AnimalDAO;
import com.tt.model.Animal;
import com.tt.model.Raca;
import com.tt.model.TipoAnimal;

@ManagedBean(name = "animalMB")
@SessionScoped
public class AnimalMB {

	private Animal animal;
	private AnimalDAO animalDAO;

	public AnimalMB() {
		animal = new Animal();
		animalDAO = new AnimalDAO();
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public AnimalDAO getAnimalDAO() {
		return animalDAO;
	}

	public void setAnimalDAO(AnimalDAO animalDAO) {
		this.animalDAO = animalDAO;
	}

	public boolean cadastrarAnimal() {
		boolean ok = false;
		if (this.animal == null) {
			System.out.println("SEM ANIMAL PARA CADASTRO");
			return ok;
		}
		ok = animalDAO.cadastrar(animal);
		if (ok == false)
			System.out.println("Erro ao Cadastrar");
		return ok;
	}

	public TipoAnimal[] getTipoAnimalValues(){
		return TipoAnimal.values();
	}
	
	public Collection<Animal> listarAnimais() {
		boolean ok = false;
		
		Collection<Animal> animais = animalDAO.listar();
		 
/*		Collection<Animal> animais = new ArrayList<Animal>();
		Raca siames = new Raca();
		Raca pitbull = new Raca();
		Raca loro = new Raca();
		Animal bobby = new Animal("Bobby", TipoAnimal.GATO, siames, "Feio");
		Animal cao = new Animal("Mike", TipoAnimal.CACHORRO, pitbull, "Bravo");
		Animal lorao = new Animal("Pedro", TipoAnimal.PASSARO, loro, "Verde");
		animais.add(lorao);
		animais.add(cao);
		animais.add(bobby);*/

		if (animais == null) {
			System.out.println("SEM ANIMAIS PARA LISTAR");
		}
		return animais;
	}

}
