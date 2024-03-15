package br.devhub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.devhub.models.Post;

public interface PostRepository extends JpaRepository<Post, String> {

}
