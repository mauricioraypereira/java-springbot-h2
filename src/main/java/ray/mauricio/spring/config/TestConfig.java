package ray.mauricio.spring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import ray.mauricio.spring.entities.Category;
import ray.mauricio.spring.entities.Order;
import ray.mauricio.spring.entities.OrderItem;
import ray.mauricio.spring.entities.Payment;
import ray.mauricio.spring.entities.Product;
import ray.mauricio.spring.entities.User;
import ray.mauricio.spring.entities.enums.OrderStatus;
import ray.mauricio.spring.repositories.CategoryRepository;
import ray.mauricio.spring.repositories.OrderItemRepository;
import ray.mauricio.spring.repositories.OrderRepository;
import ray.mauricio.spring.repositories.ProductRepository;
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
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {

		Category c1 = new Category(null, "Eletrônicos");
		Category c2 = new Category(null, "Livros");
		Category c3 = new Category(null, "Computadores");
		Category c4 = new Category(null, "Materiais de Contrução");
		
		Product p1 = new Product(null, "O Senhor dos Anéis", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "X-Man 97", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		categoryRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(c2);
		p2.getCategories().add(c1);
		p2.getCategories().add(c3);
		p3.getCategories().add(c3);
		p4.getCategories().add(c3);
		p5.getCategories().add(c2);
		p5.getCategories().add(c4);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		User u1 = new User(null, "Mauricio Ray", "mauricioteste@gmail.com", "mauricioray", "12345");
		User u2 = new User(null, "Noah Gaieski", "noahteste@gmail.com", "noahgaieski", "54321");
		User u3 = new User(null, "Rita de Cássia", "ritateste@gmail.com", "ritagaieski", "45123");
		
		Order o1 = new Order(null, Instant.parse("2024-02-01T19:53:07Z"), u1, OrderStatus.PAID);
		Order o2 = new Order(null, Instant.parse("2019-03-02T03:42:10Z"), u2, OrderStatus.WAITING_PAYMENT);
		Order o3 = new Order(null, Instant.parse("2019-04-03T15:21:22Z"), u3, OrderStatus.DELIVERED);
		Order o4 = new Order(null, Instant.parse("2019-04-03T15:21:22Z"), u1, OrderStatus.CANCELED);
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice()); 

		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Payment pay1 = new Payment(null, Instant.parse("2024-02-01T21:53:07Z"), o1);
		o1.setPayment(pay1);
		
		orderRepository.save(o1);		
	}
}
