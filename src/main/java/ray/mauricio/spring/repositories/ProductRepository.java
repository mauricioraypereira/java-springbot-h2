package ray.mauricio.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ray.mauricio.spring.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
