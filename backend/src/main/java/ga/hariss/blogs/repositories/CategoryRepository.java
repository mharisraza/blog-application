package ga.hariss.blogs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ga.hariss.blogs.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
