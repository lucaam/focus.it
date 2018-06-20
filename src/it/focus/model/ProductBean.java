package it.focus.model;

import java.io.FileInputStream;
import java.io.InputStream;

import com.mysql.jdbc.Blob;

public class ProductBean {
	
	private int id;
	private String product;
	private String brand;
	private Double price;
	private String desc;
	private Double mpx;
	private String color;
	private InputStream pic;
	private String type;
	
	
	public ProductBean(String product, Double price, String brand, String desc, Double mpx, String color/*, String type*/) {
		//used to add

		
		this.product = product;
		this.brand = brand;
		this.price = price;
		this.mpx = mpx;
		this.desc = desc;
		this.color = color;
		
		

//		this.setType(type);
		
	}
	
	public ProductBean(int id,String product, Double price, String brand, String desc, Double mpx, String color/*, String type*/) {
		//used to retrive
		
		
		this.product = product;
		this.brand = brand;
		this.price = price;
		this.mpx = mpx;
		this.desc = desc;
		this.color = color;
		
		
		this.setId(id);
//		this.setType(type);
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Double getMpx() {
		return mpx;
	}
	public void setMpx(Double mpx) {
		this.mpx = mpx;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	public InputStream getPic() {
		return pic;
	}

	public void setPic(InputStream fis) {
		this.pic = fis;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
	
	