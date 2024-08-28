
public class RegularRenter extends Renters
{
	RegularRenter(String name,String email,String phone,String address)
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
	public double rents(double distance, double cost)
	{
		
		this.totalRentalFee+=cost;
		return cost;
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
