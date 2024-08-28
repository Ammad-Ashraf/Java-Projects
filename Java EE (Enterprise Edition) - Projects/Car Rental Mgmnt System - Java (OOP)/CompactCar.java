
public class CompactCar implements Cars
{
	private static int carid=110;
	private int id;
	private final double Rental_Fee=2.0;
	public String brand,model,rentalstatus,platenumber;
	public int year;
	private final double Base_Rent=1000;
	public char insurance='n';
	private double insurance_Cost=0.0;
	public CompactCar(String b,String m,String pn,int y)
	{
		this.brand=b;
		this.model=m;
		this.rentalstatus="Available";
		this.platenumber=pn;
		this.year=y;
		id=carid++;
		
	}
	public int getcarid()
	{
		return this.id;
	}
	public String getrentalstatus()
	{
		return this.rentalstatus;
	}
	public void setrentalstatus(String status)
	{
		this.rentalstatus=status;
	}
	public char getinsurancestatus()
	{
		return this.insurance;
	}
	public double getinsurancecost()
	{
		return this.insurance_Cost;
	}
	public void displaycarinfo()
	{
		
		System.out.print(" "+this.id+"  "+this.brand+"    "+this.model+"    "+this.platenumber+"    "+this.year+"    ");
		System.out.println(Rental_Fee+"        "+this.rentalstatus);
		System.out.println("Category : Compact Car");
	}
	public double calculaterentalamount(double distance)
	{
		if(distance>=0)
		{
			System.out.println("Insurance : Not Available");
			// Base rent by default 1000Rs 
			// Charged 2Rs per kilometer to calculate distance traveled cost
			return Base_Rent+distance*Rental_Fee;	
		}else 
		{
			System.out.println("Invalid Entry");
			return -1;
		}
		
	}
	
	
}
