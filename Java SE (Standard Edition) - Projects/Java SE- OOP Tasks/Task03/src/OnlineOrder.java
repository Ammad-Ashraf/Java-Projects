import java.util.ArrayList;

class OnlineOrder implements Order 
{
    private ArrayList<Product> products;
    private ArrayList<Integer> quantities;

    public OnlineOrder()
    {
        products = new ArrayList<>();
        quantities = new ArrayList<>();
    }

    @Override
    public void addProduct(Product product, int quantity)
    {
        products.add(product);
        quantities.add(quantity);
    }

    @Override
    public void removeProduct(Product product, int quantity)
    {
        int index = products.indexOf(product);
        if (index != -1)
        {
            int currentQuantity = quantities.get(index);
            int newQuantity = currentQuantity - quantity;
            if (newQuantity <= 0)
            {
                products.remove(index);
                quantities.remove(index);
            } else 
            {
                quantities.set(index, newQuantity);
            }
        }
    }

    @Override
    public double calculateTotal()
    {
        double total = 0;
        for (int i = 0; i < products.size(); i++)
        {
            total += products.get(i).getPrice() * quantities.get(i);
        }
        return total;
    }
}
