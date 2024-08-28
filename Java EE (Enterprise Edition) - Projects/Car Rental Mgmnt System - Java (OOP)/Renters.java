import java.util.ArrayList;
public abstract class Renters 
{
		public static int id=321;
	    protected int renterID;
	    protected String name;
	    protected String email;
	    protected ArrayList<Cars> rentedCars;
	    protected double totalRentalFee;
	    protected String phoneNumber;
	    protected String address;

	    public Renters(String name, String email, String phoneNumber, String address)
	    {
	        this.renterID = id++;
	        this.name = name;
	        this.email = email;
	        this.rentedCars = new ArrayList<>();
	        this.totalRentalFee = 0.0;
	        this.phoneNumber = phoneNumber;
	        this.address = address;
	    }
	    public abstract int getid();
	    public abstract void addRentedCar(Cars car);
	    public abstract double rents(double distance,double cost);
	    public abstract void renterDetails();
	    

}
