package br.devhub.services;

import java.util.List;

import br.devhub.dto.PostDTO;
import br.devhub.models.Post;

public interface PostService {
	Post createPost(PostDTO to);
	
	List<Post> findAll(PostDTO to);
}
