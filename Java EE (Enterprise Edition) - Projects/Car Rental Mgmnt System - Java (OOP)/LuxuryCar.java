import java.util.Scanner;

public class LuxuryCar implements Cars {
	private static int carid=310;
	private int id;
	private final double Rental_Fee=4.0;
	public String brand,model,rentalstatus,platenumber;
	public int year;
	private final double Base_Rent=5000;
	public char insurance='n';
	private double insurance_Cost=0.0;
	public LuxuryCar(String b,String m,String pn,int y)
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
		System.out.println("Category : LUXURY");
	}
	public double calculaterentalamount(double distance)
	{
		System.out.println("Insurance : Available");
		System.out.print("Do you want to add insurance (y/n) : ");
		Scanner cin=new Scanner(System.in);
		String input=cin.next();
		char status=input.charAt(0);
		this.insurance=status;
		if((insurance=='y'|| insurance=='Y')&&distance>=0)
		{
			double cost=(Base_Rent+distance*Rental_Fee)+(0.5*(Base_Rent+distance*Rental_Fee));// Second factor includes the luxury tax
			this.insurance_Cost=0.20*Base_Rent;// Set 20% of the base rent for calculating insurance cost
			System.out.println("Insurance Cost : RS "+insurance_Cost);
			return cost+insurance_Cost;
		}else if(distance>=0)
		{
			// Base rent by default 5000Rs 
			// Charged 4Rs per kilometer to calculate distance traveled cost
			// luxury tax by default set 5%of the total cost
			return (Base_Rent+distance*Rental_Fee)+(0.5*(Base_Rent+distance*Rental_Fee));
		}else
		{
			System.out.println("Invalid Entry");
			return -1;
		}
		
	}

}
