package ga.hariss.blogs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ga.hariss.blogs.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
