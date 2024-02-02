package mr.iscae;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Produit {

	@JsonProperty
	private int id;
	@JsonProperty
	private String name;
	@JsonProperty
	private String codeBare;
	@JsonProperty
	private double price;
	@JsonProperty
	private int quantity;
	

	public Produit() {
		super();
	}
	
	
	public Produit(int id, String name, String codeBare, double price, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.codeBare = codeBare;
		this.price = price;
		this.quantity = quantity;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCodeBare() {
		return codeBare;
	}
	public void setCodeBare(String codeBare) {
		this.codeBare = codeBare;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
