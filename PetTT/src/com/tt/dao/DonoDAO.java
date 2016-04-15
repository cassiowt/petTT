package com.tt.dao;

import javax.persistence.EntityManager;

import com.tt.control.JpaUtil;
import com.tt.model.Dono;

public class DonoDAO {

	static EntityManager fabrica = JpaUtil.getFactory();

	public boolean cadastrarDono(Dono dono) {
		boolean ok = false;

		if (dono != null) {
			fabrica.getTransaction().begin();
			fabrica.persist(dono);
			fabrica.flush();
			fabrica.getTransaction().commit();
			fabrica.close();
			ok = true;
		}
		return ok;

	}
}
