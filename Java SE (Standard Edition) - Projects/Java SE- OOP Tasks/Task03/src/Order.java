

public interface Order 
{
    void addProduct(Product product, int quantity);
    void removeProduct(Product product, int quantity);
    double calculateTotal();
}
