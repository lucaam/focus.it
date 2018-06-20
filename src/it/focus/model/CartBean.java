package it.focus.model;

import java.util.ArrayList;

public class CartBean {
	
	private String user;
	private ArrayList<ProductBean> items = new ArrayList<ProductBean> ();
	
	public CartBean ()
	{
		this.items = new ArrayList<ProductBean> ();
	}
	public double getTotal()
	{
		Double total = 0.0;
		
		for(ProductBean pb : items)
		{
			total+=pb.getPrice();
		}
		return total;
	}
	
	public void addItem(ProductBean pb)
	{
		
		this.items.add(pb);
		
		System.out.println("aggiunto");

	}
	
	public void removeItem(ProductBean pb)
	{
		System.out.println(pb.getId());
		if(this.items.remove(pb))
			System.out.println("rimosso");
	}
	
	public ProductBean getItem(int i)
	{
		return this.items.get(i);
	}
	
	
	public ArrayList<ProductBean> getItems()
	{
		return this.items;
	}
	
	public void deleteCart()
	{
		int i = 0;
		
		while(!(this.items.isEmpty()))
				this.items.remove(i);
	}
	
	public boolean isEmpty() {
		if(this.items.isEmpty())
			return true;
		else 
			return false;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	public CartBean restoreCart (CartBean cart)
	{
		CartBeanDAO cbd = new CartBeanDAO();
		return cart = cbd.restore(cart.getUser());
	}
	
	public void deleteFromDb ( ProductBean pb)
	{
		CartBeanDAO cbd = new CartBeanDAO();
		cbd.deleteFromCart(this.getUser(), pb.getId());
	}
}
