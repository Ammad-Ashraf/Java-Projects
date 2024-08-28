package ModelPart;

public class destinationBean 
{
    private int id;
    private String name;
    private String category;
    private String description;

    // Default constructor
    public destinationBean() {
    }

    // Parameterized constructor
    public destinationBean(int id, String name, String category, String description)
    {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
    }

    // Getter and Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
