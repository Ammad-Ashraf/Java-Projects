package Service1.UserService.DataRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import Service1.UserService.Entities.users;
import java.util.Optional;

// Persistence Layer
public interface UserProfileDAO extends JpaRepository <users,Integer> 
{
	 Optional<users> findByEmail(String email);
}
