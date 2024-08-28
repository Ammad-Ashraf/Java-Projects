
public class Main 
{

	public static void main(String[] args) 
	{
		RentalServicesManagement manage=new RentalServicesManagement();
		// Add new cars of different types
		Cars obj=new CompactCar("Corola","2010","LAS-535",5);
		manage.addcars(obj);
		obj=new SUV("Toyota","2024","LUI-234",1);
		manage.addcars(obj);
		obj=new LuxuryCar("Merced","2023","HUI-990",2);
		manage.addcars(obj);
		System.out.println("");
		// display available cars
		manage.showcars();
		System.out.println("");
		// remove a car
		manage.removeacar(310);
		System.out.println("");
		manage.showcars();
		System.out.println("");
		// add renters of different types
		Renters obj1=new RegularRenter("Ammad","ashraf1@gmail.com","031789","Lahore");
		manage.addrenters(obj1);
		obj1=new FrequentRenters("Zain","Zain1@gmail.com","031945","Jhang");
		manage.addrenters(obj1);
		obj1=new CorporateRenters("Hamza","hamza2@gmail.com","242356","FSD");
		manage.addrenters(obj1);
		// renter details test cases
		int id=0;
		System.out.println("");
		manage.renter_details(id);
		id=322;
		
		// rent a car
		System.out.println("");
		manage.rentcar(210, id);
		System.out.println("");
		manage.renter_details(id);
		System.out.println("");
		//return car and damage cost calculations
		manage.returning_Car(210, id);
		
		
		

		
		

	}

}
