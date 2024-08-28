package Ammad.Projectname;

import org.springframework.beans.factory.annotation.Autowired;

public class coffeeShop
{
	@Autowired
	private Coffee coffee; // field injection 

    public void serveCoffee()
    {
        System.out.println("Serving Coffee ....");
        coffee.DisplayDetails();
    }
}