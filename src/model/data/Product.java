package model.data;

public class Product {
	
	private int ID;
	private String Name;
	private int Price;
	private int Price_promotion;
	private String Description;
	private int CategoryID;
	private String ImageLink;
	private String MakerDate;
	private String Maker;
	
	public Product() {
		
		
	}
	

	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public int getPrice() {
		return Price;
	}


	public void setPrice(int price) {
		Price = price;
	}


	public int getPrice_promotion() {
		return Price_promotion;
	}


	public void setPrice_promotion(int price_promotion) {
		Price_promotion = price_promotion;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}


	public int getCategoryID() {
		return CategoryID;
	}


	public void setCategoryID(int categoryID) {
		CategoryID = categoryID;
	}


	public String getImageLink() {
		return ImageLink;
	}


	public void setImageLink(String imageLink) {
		ImageLink = imageLink;
	}


	public String getMakerDate() {
		return MakerDate;
	}


	public void setMakerDate(String makerDate) {
		MakerDate = makerDate;
	}


	public String getMaker() {
		return Maker;
	}


	public void setMaker(String maker) {
		Maker = maker;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
