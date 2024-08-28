package Service1.UserService.Service;

// Grasp Pattern - Low Coupling , High Cohesion , Indirection 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Service1.UserService.DataRepositories.UserProfileDAO;
import Service1.UserService.Entities.users;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService
{

    @Autowired
    private UserProfileDAO userProfileDAO;

    public List<users> getAllUsers()
    {
        return userProfileDAO.findAll();
    }

    public Optional<users> getUserById(Integer id)
    {
        return userProfileDAO.findById(id);
    }

    public String registerUser(users user)
    {
        // Check if the email is already registered
        Optional<users> existingUser = userProfileDAO.findByEmail(user.getEmail());
        if (existingUser.isPresent()) 
        {
            return "Email is already registered.";
        }

        // Save the user
        userProfileDAO.save(user);
        return "User registered successfully.";
    }

    public void deleteUser(Integer id)
    {
        userProfileDAO.deleteById(id);
    }

    public String updateUser(Integer id, users user)
    {
        // Retrieve the user from the database
        Optional<users> optionalUser = userProfileDAO.findById(id);

        // Check if the user exists
        if (optionalUser.isPresent()) 
        {
            // Set the ID to ensure we update the correct user
            user.setId(id);

            // Update the user's information
            userProfileDAO.save(user);
            
            // Return success message
            return "User updated successfully.";
        } else {
            // If the user does not exist, return error message
            return "User with ID " + id + " not found.";
        }
    }

    public String login(String email, String password) {
        // Find user by email
        Optional<users> optionalUser = userProfileDAO.findByEmail(email);

        // Check if user exists and password matches
        if (optionalUser.isPresent()) {
            users user = optionalUser.get();
            if (user.getPassword().equals(password)) {
                return "Login successful.";
            } else {
                return "Incorrect password.";
            }
        } else {
            return "User with email " + email + " not found.";
        }
    }

}
