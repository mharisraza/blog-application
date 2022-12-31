package ga.hariss.blogs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ga.hariss.blogs.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
