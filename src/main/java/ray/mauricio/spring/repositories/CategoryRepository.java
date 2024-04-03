package ray.mauricio.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ray.mauricio.spring.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
