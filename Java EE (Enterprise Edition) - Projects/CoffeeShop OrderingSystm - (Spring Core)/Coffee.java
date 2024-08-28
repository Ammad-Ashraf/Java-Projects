package Ammad.Projectname;

abstract public class Coffee
{
    protected String type;
    protected String size;
    protected double price;

    // Setters
    public void setType(String type)
    {
        this.type = type;
    }

    public void setSize(String size)
    {
        this.size = size;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
    
    // abstract method for coffee details
    abstract void DisplayDetails();
    
}
