package Ammad.Projectname;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Driver_Task01 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("CoffeeBeans.xml");

        coffeeShop coffeeshop = (coffeeShop)context.getBean("coffeeShop");

        coffeeshop.serveCoffee();
        
        context.close();
    }
}
