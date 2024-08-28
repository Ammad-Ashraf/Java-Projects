import java.util.ArrayList;
import java.util.Scanner;
public class RentalServicesManagement 
{
	private ArrayList<Cars> total_cars;
	private ArrayList<Renters> total_renters;
	private ArrayList<ArrayList<Double>> transactions;
	public RentalServicesManagement()
	{
		total_cars=new ArrayList<>();
		total_renters=new ArrayList<>();
		transactions=new ArrayList<>();
	}
	// Car Management Modules Functions
	
	void addcars(Cars obj)
	{
		total_cars.add(obj);
		System.out.println("Car has been added to your record");
	}
	
	void removeacar(int carid)
	{
		boolean find=false;
		for(int i=0;i<total_cars.size();i++)
		{
			if(total_cars.get(i).getcarid()==carid)
			{
				if(total_cars.get(i).getrentalstatus()=="Available")
				{
					total_cars.remove(i);
					System.out.println("Car has been removed from record");
					find=true;
					break;
				}	
			}
		}
		if(find==false)
		{
			System.out.print("Car has already rented out or not available");
		}
	}
	
	void showcars()
	{
		if(total_cars.isEmpty())
		{
			System.out.println("No cars Available");
			return;
		}
		System.out.println("CarID  "+"Brand  "+"Model  "+"PlateNumber  "+"Year  "+"RentalFee  "+"RentalStatus");
		for(int i=0;i<total_cars.size();i++)
		{
			if(total_cars.get(i).getrentalstatus()=="Available")
			{
				total_cars.get(i).displaycarinfo();
			}
		}
	}
	// Renter Management Modules Functions
	
	boolean renter_details(int id)
	{
		boolean find=false;
		if(total_renters.isEmpty())
		{
			System.out.println("No renter Registered");
			return false;
		}
		if(id==0)
		{
			for(int i=0;i<total_renters.size();i++)
			{
				total_renters.get(i).renterDetails();
				System.out.println("");
				
			}
			find=true;
			return true;
		}
		else
		{
			for(int i=0;i<total_renters.size();i++)
			{
				if(total_renters.get(i).getid()==id)
				{
					
					total_renters.get(i).renterDetails();
					find=true;
					return true;
				}
			}
		}
		if(find==false)
		{
			System.out.println("Renter not found");
			return false;
		}
		return find;
		
	}
	
	void addrenters(Renters obj)
	{
		total_renters.add(obj);
		System.out.println("Renter has been added to your record");	
	}
	
	// Rental Transactions And rent a car to the renter modules 
	
	void rentcar(int carid,int renterid)
	{
		System.out.println("");
		System.out.println("RENTAL DETAILS");
		System.out.println("----------------------------------------------------");
		System.out.println("");
		System.out.println("------Renter Details-------");
		System.out.println("");
		boolean rentersearch=renter_details(renterid);
		if(rentersearch==true)
		{
			boolean find=false;
			for(int i=0;i<total_cars.size();i++)
			{
				if(total_cars.get(i).getcarid()==carid)
				{
					if(total_cars.get(i).getrentalstatus()=="Available")
					{
						System.out.println("");	
						System.out.println("------Car Details-------");
						System.out.println("");	
						System.out.println("CarID  "+"Brand  "+"Model  "+"PlateNumber  "+"Year  "+"RentalFee  "+"RentalStatus");
						total_cars.get(i).displaycarinfo();
						System.out.println("");
						total_cars.get(i).setrentalstatus("Rented");
						find=true;
						total_renters.get(i).addRentedCar(total_cars.get(i));
						rental_transactions(total_renters.get(i),total_cars.get(i));
						break;
					}	
				}
			}
			
			if(find==false)
			{
				System.out.print("Not available for rental");
			}
		}
		
	}
	void rental_transactions(Renters renter,Cars car)
	{
		Scanner cin=new Scanner(System.in);
		System.out.println("------Rental Cost-------");
		System.out.println("");
		double cost,distance,total_cost;
		System.out.print("Estimated Distance (km) : ");
		distance=cin.nextDouble();
		cost=car.calculaterentalamount(distance);
		System.out.println("Rental Cost : RS "+cost);
		total_cost=renter.rents(distance, cost);
		System.out.println("Total Rental Cost : RS "+total_cost);
		System.out.println("");
		System.out.println("---Car has been rented out successfully---");
		System.out.println("");
		System.out.println("----------------------------------------------------");
		
		// Storing rental transactions
		ArrayList<Double> rows=new ArrayList<>();
		rows.add((double)renter.getid());
		rows.add((double)car.getcarid());
		rows.add(total_cost);
		char insurance_status=car.getinsurancestatus();
		double temp=0.0;
		if(insurance_status=='y' || insurance_status=='Y' )
		{
			temp=1.0;
		}
		rows.add(temp);
		transactions.add(rows);
		
		
	}
	void returning_Car(int carid,int renterid)
	{
		
		System.out.println("");
		System.out.println("------Renter Details-------");
		System.out.println("");
		boolean rentersearch=false;
		boolean carsearch=false;
		int renterlocation=0;
		int carlocation=0;
		for(int i=0;i<total_renters.size();i++)
		{
			if(total_renters.get(i).getid()==renterid)
			{
				total_renters.get(i).renterDetails();
				rentersearch=true;
				renterlocation=i;
				break;
			}
		}
		if(rentersearch==true)
		{
			Renters temp=total_renters.get(renterlocation);
			for(int i=0;i<temp.rentedCars.size();i++)
			{
				if(temp.rentedCars.get(i).getcarid()==carid)
				{
					carlocation=i;
					temp.rentedCars.get(i).setrentalstatus("Available");
					temp.rentedCars.remove(i);
					carsearch=true;
					break;
				}
			}
			if(carsearch==true)
			{
				double damage_cost=0.0;
				System.out.println("");
				System.out.print("Is there any damage issue (y/n) : ");
				Scanner scan=new Scanner(System.in);
				String input=scan.next();
				char damage=input.charAt(0);
				
				if(damage=='y'||damage=='Y')
				{
					if (!transactions.isEmpty())
					{ // Check if transactions list is not empty
					    for (int i = 0; i < transactions.size(); i++)
					    {
					        if (!transactions.get(i).isEmpty())
					        { // Check if the inner list is not empty
					            for (int j = 0; j < transactions.get(i).size(); j++)
					            {
					                if (transactions.get(i).get(j).equals(carid))
					                { 
					                	if(transactions.get(i).get(3)==0.0)
										{
											// damage percentage set 10% for un-insured cars
											damage_cost=transactions.get(i).get(2)*0.1;
											break;
										}else
										{
											// damage percentage set 5% for insured cars
											double insurance_cost=temp.rentedCars.get(carlocation).getinsurancecost();
											damage_cost=Math.max(500.0,(transactions.get(i).get(2)*0.5)-insurance_cost);
											break;
										}
					                }
					            }
					        }
					    }
					}
					System.out.println("");
					System.out.println("Damage Cost : RS "+damage_cost);
					System.out.println("Car has been returned successfully");
					System.out.println("-----------------------------------");
					System.out.println("");
					
				}else
				{
					System.out.println("");
					System.out.println("Car has been returned successfully");
					System.out.println("-----------------------------------");
					System.out.println("");
				}
				
			}else
			{
				System.out.print("Car not found");		
			}
			
		}
		else
		{
			System.out.print("Renter not found");	
		}
		
	}
	
}
