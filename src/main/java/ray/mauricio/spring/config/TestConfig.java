package ray.mauricio.spring.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import ray.mauricio.spring.entities.User;
import ray.mauricio.spring.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Mauricio Ray", "mauricioteste@gmail.com", "mauricioray", "12345");
		User u2 = new User(null, "Noah Gaieski", "noahteste@gmail.com", "noahgaieski", "54321");
		User u3 = new User(null, "Rita de Cássia", "ritateste@gmail.com", "ritagaieski", "45123");
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		
	}
	
	
	
}
