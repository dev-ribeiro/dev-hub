package br.devhub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.devhub.models.Post;

public interface PostRepository
		extends JpaRepository<Post, String>, PagingAndSortingRepository<Post, String>, JpaSpecificationExecutor<Post> {
}
