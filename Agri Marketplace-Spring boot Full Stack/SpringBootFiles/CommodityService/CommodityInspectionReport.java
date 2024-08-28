package Tayyab.Project.entity;

public class CommodityInspectionReport {
    private String name;
    private double price;
    private int quantity;
    private boolean goodForBuying;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public boolean isGoodForBuying() {
		return goodForBuying;
	}
	public void setGoodForBuying(boolean goodForBuying) {
		this.goodForBuying = goodForBuying;
	}
	
	public CommodityInspectionReport() {
    }

    public CommodityInspectionReport(String name, double price, int quantity, boolean goodForBuying) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.goodForBuying = goodForBuying;
    }

}

