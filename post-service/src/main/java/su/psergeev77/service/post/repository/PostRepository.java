package su.psergeev77.service.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import su.psergeev77.service.post.model.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByUserName(String userName);
}
