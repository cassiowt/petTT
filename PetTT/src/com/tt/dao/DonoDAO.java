package com.tt.dao;

import java.util.Collection;

import javax.persistence.EntityManager;

import com.tt.control.JpaUtil;
import com.tt.model.Dono;

public class DonoDAO {

	static EntityManager fabrica = JpaUtil.getFactory();

	public boolean cadastrar(Dono dono) {
		if (dono != null) {
			fabrica.getTransaction().begin();
			fabrica.persist(dono);
			fabrica.flush();
			fabrica.getTransaction().commit();
			fabrica.close();
			return true;
		}
		
		return false;
	}
		
	public Collection<Dono> listar() {
		javax.persistence.Query query = (javax.persistence.Query) fabrica.createNamedQuery("queryDono");
		 return query.getResultList();
	}
	
	public boolean remover(Dono dono) {
		if (dono != null) {
			
			fabrica.getTransaction().begin();
			Dono donoDB = fabrica.find(Dono.class, dono.getId());			
			
			if(donoDB != null) {
				fabrica.remove(donoDB);	
			}
			
			fabrica.getTransaction().commit();
			fabrica.close();
			return true;
		}
		
		return false;
	}
}
