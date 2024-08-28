
public class Task03 {

	public static void main(String[] args)
	{
		
        Product iPhone = new Electronics("iPhone 12", 999.99, "Latest Apple iPhone");
        Product tShirt = new Clothing("T-Shirt", 19.99, "Cotton t-shirt");
        Product javaBook = new Books("Java", 39.99, "Java programming best practices");

        
        Customer customer = new Customer("Ammad", "ammad@gmail.com", "Islamabad");

        
        Order order1 = new OnlineOrder();
        order1.addProduct(iPhone, 1);
        order1.addProduct(tShirt, 2);
        customer.placeOrder(order1);

        Order order2 = new OnlineOrder();
        order2.addProduct(javaBook, 1);
        customer.placeOrder(order2);

       
        customer.viewOrderHistory();
    }

	

}
