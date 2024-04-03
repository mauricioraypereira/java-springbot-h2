package ray.mauricio.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ray.mauricio.spring.entities.Product;
import ray.mauricio.spring.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository userRepository;
	
	public List<Product> findAll() {
		return userRepository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> user = userRepository.findById(id);
		return user.get();
	}
}
