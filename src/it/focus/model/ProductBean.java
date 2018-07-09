package it.focus.model;

public class ProductBean {
	
	private int id; //id_product
	private String product; // product_name
	private String brand; //brand
	private Double price; //price
	private String desc; //description
	private Double mpx; //mpx
	private String color; //colour
	private String pic; //img
	private String type; //product_type
	
	
	public ProductBean(String product, Double price, String brand, String desc, Double mpx, String color/*, String type*/, String pic) {
		//used to add

		
		this.product = product;
		this.brand = brand;
		this.price = price;
		this.mpx = mpx;
		this.desc = desc;
		this.color = color;
		this.pic = pic;
		
		

//		this.setType(type);
		
	}
	
	public ProductBean(int id, String product, Double price, String brand, String desc, Double mpx, String color/*, String type*/, String pic) {
		//used to retrive
		
		
		this.product = product;
		this.brand = brand;
		this.price = price;
		this.mpx = mpx;
		this.desc = desc;
		this.color = color;
		this.pic = pic;
		
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

	public String getPic() {
		return pic;
	}

	public void setPic(String fis) {
		this.pic = fis;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
	
	