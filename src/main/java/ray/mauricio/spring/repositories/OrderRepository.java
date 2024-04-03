package ray.mauricio.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ray.mauricio.spring.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
