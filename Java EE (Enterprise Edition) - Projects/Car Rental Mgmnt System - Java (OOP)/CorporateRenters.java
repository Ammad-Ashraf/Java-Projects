
public class CorporateRenters extends Renters 
{
	CorporateRenters(String name,String email,String phone,String address)
	{
		super(name,email,phone,address);
	}
	public int getid()
	{
		return this.renterID;
	}
	public void addRentedCar(Cars obj)
	{
		this.rentedCars.add(obj);
	}
	public double rents(double distance,double cost)
	{
		
		
		System.out.println("You got 20% from your total Rental Cost of : Rs "+0.2*cost);
		double discounts=cost-(0.2*cost);// provide 20% discount on total rental cost
		this.totalRentalFee+=discounts;
		return discounts;
	}
	public void renterDetails()
	{
		System.out.println("ID  "+"Name  "+"Email Address       "+"Phone Number   "+"Address  ");
		System.out.println(this.renterID+" "+this.name+" "+this.email+"    "+this.phoneNumber+"        "+this.address);
		System.out.println("");
		System.out.println(" Total Rental_Fee : RS " +this.totalRentalFee);
		System.out.println("");
		System.out.println(" Your Rented Cars");
		if(rentedCars.isEmpty())
		{
			System.out.println(" No cars rented by you");
			return;
		}
		System.out.println("CarID  "+"Brand  "+"Model  "+"PlateNumber  "+"Year  "+"RentalFee  "+"RentalStatus");
		for(int i=0;i<this.rentedCars.size();i++)
		{
			this.rentedCars.get(i).displaycarinfo();
		}
		
	}

}
