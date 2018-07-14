package it.focus.model;

import java.util.ArrayList;

public class CartBean {
	
	private String user;
	private ProdListCart pList;

	public CartBean()
	{
		this.user = new String();
		this.pList = new ProdListCart();
	}
	
	public void setUser(String user)
	{
		this.user = user;
	}
	
	public String getUser() {
		return this.user;
	}

	public void addItem(ProductBean pb, int qta) {
		this.pList.Add(pb, qta);
	}
	
	public void removeItem(ProductBean pb, int qta)
	{
		this.pList.Remove(pb, qta);
	}
	
	public Double getTotal()
	{
		return this.pList.totPrice();
	}
	
	public boolean isEmpty()
	{
		return this.pList.isEmpty();
	}
	
	public CartBean restoreCart(CartBean cart)
	{
		CartBeanDAO cbd = new CartBeanDAO();
		return cart = cbd.restore(cart.getUser());
		
	}

	public void deleteFromDb(ProductBean pb) {
		CartBeanDAO cbd = new CartBeanDAO();
		cbd.deleteFromCart(this.getUser(), pb.getId());
		
	}
	
	public ArrayList<ProductBean> getItems()
	{
		return this.pList.getItems();
	}
	
	public ArrayList<Integer> getQtas()
	{
		return this.pList.getQtaList();
	}

}