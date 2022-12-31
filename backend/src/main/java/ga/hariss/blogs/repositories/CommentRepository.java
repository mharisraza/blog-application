package ga.hariss.blogs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ga.hariss.blogs.entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
