package RESTful.Service.ModelPart;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DestinationService
{

    @Autowired
    private DestinationRepository destinationDAO;

    // Find all destinations
    public List<Destination> findAll()
    {
        return destinationDAO.findAll();
    }

    // Find one destination by ID
    public Destination findOne(int id)
    {
        return destinationDAO.findById(id).get();
    }

    // Save a new destination
    public Destination saved(Destination destination)
    {
        destinationDAO.save(destination);   
        return destination;
    }

    // Delete a destination by ID
    public void deleteById(int id)
    {
        Destination destination = findOne(id);
        if (destination != null)
        {
            destinationDAO.deleteById(id);
        } else 
        {
            throw new RuntimeException("Destination not found with id: " + id);
        }
    }

    // Update an existing destination
    public Destination updateDestination(Destination destination)
    {
        if (destination.getId() != null)
        {
            destinationDAO.save(destination);
        } else 
        {
            throw new RuntimeException("Destination not found with id: " + destination.getId());
        }
        return destination;
    }
}
