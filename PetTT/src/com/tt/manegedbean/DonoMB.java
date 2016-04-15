package com.tt.manegedbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;

import com.tt.dao.DonoDAO;
import com.tt.model.Dono;

@ManagedBean(name = "donoMB")
@SessionScoped
public class DonoMB implements Serializable {

	private static final long serialVersionUID = 7427334381930431970L;

	private Dono dono;
	private DataModel donos;
	private DonoDAO donoDao;

	public DonoMB() {
		dono = new Dono();
		donos = new ArrayDataModel(new Dono[]{
			new Dono("João", "33224422", "rua blblbl"),
			new Dono("João", "33224422", "rua blblbl"),
			new Dono("João", "33224422", "rua blblbl"),
			new Dono("João", "33224422", "rua blblbl")
			});
	}

	public Dono getDono() {
		return dono;
	}

	public void setDono(Dono dono) {
		this.dono = dono;
	}

	
	public DataModel<Dono> getDonos() {
		return donos;
	}

	public void setDonos(DataModel<Dono> donos) {
		this.donos = donos;
	}

}
