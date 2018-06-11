package it.focus.model;

import java.util.ArrayList;

public class OrderBean {
	private int id_usroder;
	private int id_usr;
	private ArrayList <ProductBean> products;
	
	
	public int getId_usroder() {
		return id_usroder;
	}
	public void setId_usroder(int id_usroder) {
		this.id_usroder = id_usroder;
	}
	public ArrayList <ProductBean> getProducts() {
		return products;
	}
	public void setProducts(ArrayList <ProductBean> products) {
		this.products = products;
	}
	public int getId_usr() {
		return id_usr;
	}
	public void setId_usr(int id_usr) {
		this.id_usr = id_usr;
	}
	
	

}
