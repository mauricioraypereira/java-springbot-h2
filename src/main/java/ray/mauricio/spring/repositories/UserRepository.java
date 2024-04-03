package ray.mauricio.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ray.mauricio.spring.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
