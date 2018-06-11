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
	private FileInputStream pic;
	private String type;
	
	
	public ProductBean(/*id, */String product, Double price, String brand, String desc, Double mpx, String color/*, String type*/) {
		this.setBrand(brand);
		this.setDesc(desc);
		this.setPrice(price);
//		this.setId(id);
//		this.setType(type);
		this.setProduct(product);
		this.setColor(color);
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

	public FileInputStream getPic() {
		return pic;
	}

	public void setPic(FileInputStream fis) {
		this.pic = fis;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
	
	