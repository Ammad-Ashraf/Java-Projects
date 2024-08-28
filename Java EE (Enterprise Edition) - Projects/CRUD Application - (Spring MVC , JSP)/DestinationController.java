package RESTful.Service.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import RESTful.Service.ModelPart.DestinationService;


@RestController
public class DestinationController 
{
    @Autowired
    private DestinationService service;

    // Get all destinations
    @GetMapping("/destinations")
    public List<RESTful.Service.ModelPart.Destination> retrieveAllDestinations()
    {
        return service.findAll();
    }

    // Get a single destination by ID
    @GetMapping("/destinations/{id}")
    public RESTful.Service.ModelPart.Destination retrieveDestination(@PathVariable int id)
    {
        RESTful.Service.ModelPart.Destination destination = service.findOne(id);
        if (destination == null) 
        {
            throw new RuntimeException("Destination not found with id: " + id);
        }
        return destination;
    }

    // Create a new destination
    @PostMapping("/destinations")
    public RESTful.Service.ModelPart.Destination createDestination(@RequestBody RESTful.Service.ModelPart.Destination destination)
    {
        RESTful.Service.ModelPart.Destination savedDestination = service.saved(destination);
        return savedDestination;
    }

    // Delete a destination
    @DeleteMapping("/destinations/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDestination(@PathVariable int id)
    {
        RESTful.Service.ModelPart.Destination existingDestination = (RESTful.Service.ModelPart.Destination) service.findOne(id);
        if (existingDestination == null)
        {
            throw new RuntimeException("Destination not found with id: " + id);
        }
        service.deleteById(id);
    }

    // Update an existing destination
    @PutMapping("/destinations/{id}")
    public RESTful.Service.ModelPart.Destination updateDestination(@RequestBody RESTful.Service.ModelPart.Destination destination, @PathVariable int id)
    {
        RESTful.Service.ModelPart.Destination existingDestination = (RESTful.Service.ModelPart.Destination) service.findOne(id);
        if (existingDestination == null)
        {
            throw new RuntimeException("Destination not found with id: " + id);
        }
        return service.updateDestination(destination);
    }
}
