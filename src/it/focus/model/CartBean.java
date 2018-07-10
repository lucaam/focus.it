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
		
		if(this.items.add(pb))
		
		System.out.println("aggiunto correttamente al carrello");

	}
	
	public void removeItem(ProductBean pb)
	{
		for(ProductBean tmp : this.items) {
			if(tmp.getId()==pb.getId()){
				this.items.remove(tmp);
				System.out.println("removed");
				return;
			}
				
			
		}
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
				i++;
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
