package ga.hariss.blogs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ga.hariss.blogs.entities.Category;
import ga.hariss.blogs.entities.Post;
import ga.hariss.blogs.entities.User;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
	
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);

}
