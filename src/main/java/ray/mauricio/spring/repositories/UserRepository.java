package ray.mauricio.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ray.mauricio.spring.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
