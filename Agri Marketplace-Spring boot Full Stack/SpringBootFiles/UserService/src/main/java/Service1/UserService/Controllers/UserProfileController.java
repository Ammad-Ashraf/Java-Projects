package Service1.UserService.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import Service1.UserService.Entities.users;
import Service1.UserService.Service.UserProfileService;

@RestController
@RequestMapping("/users")
public class UserProfileController 
{

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping("/")
    public List<users> getAllUsers() 
    {
        return userProfileService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<users> getUserById(@PathVariable Integer id) 
    {
        return userProfileService.getUserById(id);
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody users user)
    {
        return userProfileService.registerUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id)
    {
        userProfileService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable Integer id, @RequestBody users user) {
        return userProfileService.updateUser(id, user);
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password)
    {
        return userProfileService.login(email, password);
    }
}
