package it.focus.model;

import java.util.ArrayList;

public class CartBean {
	
	private UserBean ub;
	private ArrayList<ProductBean> items;
	
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
	}
	
	public void removeItem(ProductBean pb)
	{
		this.items.remove(pb);
	}
	
	public ProductBean getItem(int i)
	{
		return this.items.get(i);
	}
	
	public void setId(int id) {
		this.ub.setId(id);
	}
	
	public int getId() {
		return this.ub.getId();
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
}
