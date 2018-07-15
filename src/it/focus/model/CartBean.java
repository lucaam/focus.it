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
		int temp = (int)(pList.totPrice()*100.0);
	    return ((double)temp)/100.0;
		
	}
	
	public boolean isEmpty()
	{
		return this.pList.isEmpty();
	}
	
	public CartBean restoreCart()
	{
		CartBeanDAO cbd = new CartBeanDAO();
		return cbd.restore(this.user);
		
	}
	
	public void saveCart(CartBean cart, ProductBean pb, int qta)
	{
		CartBeanDAO cbd = new CartBeanDAO();
		//dovrebbe essete qta ma al momento non viene mai inviata una qta maggiore di 1
		cbd.saveCart (cart, pb, this.pList.getSpecQta(pb));
		
	}

	public void deleteFromDb(ProductBean pb, int qta) {
		CartBeanDAO cbd = new CartBeanDAO();
		cbd.deleteFromCart(this.getUser(), pb.getId(), qta);
		System.out.println("ID UTENTE: " + this.getUser() + "ID PROD DA ELIMINARE: " + pb.getId() + "qta to remove: "  + qta);
		
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