package ga.hariss.blogs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ga.hariss.blogs.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}