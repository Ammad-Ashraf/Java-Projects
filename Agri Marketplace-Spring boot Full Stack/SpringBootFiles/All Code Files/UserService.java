package Tayyab.Project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Tayyab.Project.dao.UserDao;
import Tayyab.Project.entity.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDao userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public String registerUser(User user) {
        // Check if the email is already registered
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            return "Email is already registered.";
        }

        // Save the user
        userRepository.save(user);
        return "User registered successfully.";
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public String updateUser(Integer id, User user) {
        // Retrieve the user from the database
        Optional<User> optionalUser = userRepository.findById(id);

        // Check if the user exists
        if (optionalUser.isPresent()) {
            // Set the ID to ensure we update the correct user
            user.setId(id);

            // Update the user's information
            userRepository.save(user);

            // Return success message
            return "User updated successfully.";
        } else {
            // If the user does not exist, return error message
            return "User with ID " + id + " not found.";
        }
    }

    public String login(String email, String password) {
        // Find user by email
        Optional<User> optionalUser = userRepository.findByEmail(email);

        // Check if user exists and password matches
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
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
