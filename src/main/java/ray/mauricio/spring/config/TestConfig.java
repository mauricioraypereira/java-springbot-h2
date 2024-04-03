package ray.mauricio.spring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import ray.mauricio.spring.entities.Category;
import ray.mauricio.spring.entities.Order;
import ray.mauricio.spring.entities.User;
import ray.mauricio.spring.entities.enums.OrderStatus;
import ray.mauricio.spring.repositories.CategoryRepository;
import ray.mauricio.spring.repositories.OrderRepository;
import ray.mauricio.spring.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void run(String... args) throws Exception {

		Category c1 = new Category(null, "Eletrônicos");
		Category c2 = new Category(null, "Livros");
		Category c3 = new Category(null, "Computadores");
		Category c4 = new Category(null, "Materiais de Contrução");
		
		User u1 = new User(null, "Mauricio Ray", "mauricioteste@gmail.com", "mauricioray", "12345");
		User u2 = new User(null, "Noah Gaieski", "noahteste@gmail.com", "noahgaieski", "54321");
		User u3 = new User(null, "Rita de Cássia", "ritateste@gmail.com", "ritagaieski", "45123");
		
		Order o1 = new Order(null, Instant.parse("2024-02-01T19:53:07Z"), u1, OrderStatus.PAID);
		Order o2 = new Order(null, Instant.parse("2019-03-02T03:42:10Z"), u2, OrderStatus.WAITING_PAYMENT);
		Order o3 = new Order(null, Instant.parse("2019-04-03T15:21:22Z"), u3, OrderStatus.DELIVERED);
		Order o4 = new Order(null, Instant.parse("2019-04-03T15:21:22Z"), u1, OrderStatus.CANCELED);
		
		
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4));
		categoryRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
	}
}
