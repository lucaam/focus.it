package it.focus.model;

import java.util.ArrayList;

public class CartBean {
	
	private String user;
	private ArrayList<ProductBean> items = new ArrayList<ProductBean> ();
	private ArrayList<Integer> qta = new ArrayList<Integer>();
	
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
		return round(total, 2);     

	}
	
	public void addItem(ProductBean pb)
	{
		int i = 0;
		int e = 0;
		this.items.add(pb);

		
		for(ProductBean tmp : this.items)
		{
			if(tmp.getId()==pb.getId())
				i++;
				System.out.println("esiste " + i + " volte");
				
		}
		
		if(i>1) {
			int where = 0;
			if((qta.indexOf(pb.getId())%2==0)) {
				if(qta.indexOf(pb.getId())!=-1) {
					where=qta.indexOf(pb.getId());
					qta.add(where+1, i);
			
					System.out.println("Aggiornata correttamente la quantità");
					System.out.println("Id Prodotto :" + qta.get(where) + ", Quantità: " + qta.get(where+1));
				}
			}
		}
		else if(i==1) {
			int x  = qta.size();
			
			System.out.println("Grandezza array : " + x);

			qta.add(pb.getId());
			qta.add(1);
			
		System.out.println("Aggiunto correttamente al carrello per la PRIMA volta");
		System.out.println("Id Prodotto: " + qta.get(x) + ", Quantità: " + qta.get(x+1) + "");
		
		}
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
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	
	public ProductBean last()
	{
		return items.get(items.size()-1);
		
	}
	
	public int getQta(ProductBean pb)
	{	
		int i = 0;
		while(i<qta.size()) {
	
			if(i==pb.getId()) {
				return (qta.indexOf(i)+1);
			}
			i=i+2;
		}
		return 0;
	}	
}