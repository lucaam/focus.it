package it.lucaamoriello.focusit.model;

import java.util.ArrayList;

public class ProdListCart {

	private ArrayList<ProductBean> prods;

	private ArrayList<Integer> qta;

	public ProdListCart()
	{
		this.prods = new ArrayList<ProductBean>();
		this.qta = new ArrayList<Integer>();
	}
	
	public Boolean Add(ProductBean pb, int qta)
	{
		System.out.println("Id prodotto da aggiungere: " + pb.getId());
		if(this.prods.size()==0 && this.qta.size()==0)
		{
			this.prods.add(pb);
			this.qta.add(qta);
			System.out.println("Primo prodotto in assoluto, aggiunto");

			return true;
		}
		if(this.prods.size()> 0 && this.qta.size()>0 ) {
			System.out.println("N prodotti in list: " + this.prods.size() + "N qta in lista: " + this.qta.size());
			int i = this.prods.size()-1;
			while(i>=0) {
	
				if((this.prods.get(i).getId()==pb.getId()))
				{		
					System.out.println("Id trovato: " + this.prods.get(i).getId());
	
					
	
					int add = this.qta.get(i);
					System.out.println("Qta prima di aggiornamento: " + add);
	
					this.qta.set(i, add+qta);
					System.out.println("Prodotto trovato nella lista, qta aggiornata");
	
					return true;	
					
				}
				i--;
				
				
		}
		}
		
			this.prods.add(pb);
			this.qta.add(qta);
			System.out.println("Prodotto mai inserito, aggiunto");

			return true;
		
		

	}
	
	public Boolean Remove(ProductBean pb, int qta)
	{
		for(ProductBean temp : this.prods) {
		if(temp.getId()==pb.getId())
		{
			System.out.println("Id corrispondono");

			int index = -1;
			index = this.prods.indexOf(temp);

				
					if(index!=-1) {
						int remove = this.qta.get(index);
						if(remove-qta>0) {
							this.qta.set(index, remove-qta);
							System.out.println("Prodotto trovato nella lista, qta aggiornata");

							return true;
						}else {
							this.qta.remove(index);
							this.prods.remove(index);
							System.out.println("Prodotto trovato nella lista, eliminato definitivamente");

							return true;
						}
					
			}
		}
		}
		System.out.println("Prodotto non trovato nella lista dei prodotti");
		return false;
	}
	
	public Double totPrice()
	{
		Double tot = (double) 0;
		int i = 0;
		for(ProductBean tmp : this.prods) {
			tot+=(tmp.getPrice()*this.qta.get(i++));
		}
		return tot;
	
	}
	
	public boolean isEmpty()
	{
		return this.prods.isEmpty();
		
	}
	
	public ArrayList<ProductBean> getItems()
	{
		return this.prods;
	}

	public ArrayList<Integer> getQtaList() {
		return this.qta;
	}
	
	public int getSpecQta(ProductBean pb)
	{
		int i = this.prods.size()-1;

	
		while(i>=0) {
			
			if((this.prods.get(i).getId()==pb.getId()))
			{		
				System.out.println("Id trovato: " + this.prods.get(i).getId());

				System.out.println("Prodotto trovato nella lista, qta ritornata");


				return this.qta.get(i);

				
			}
			i--;
	}
		return -1;
	
	}
}