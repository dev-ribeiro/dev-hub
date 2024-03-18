package br.devhub.services;

import java.text.ParseException;
import java.util.List;

import br.devhub.dto.PostDTO;
import br.devhub.models.Post;

public interface PostService {
	Post createPost(PostDTO to) throws ParseException;
	
	List<Post> findAll(PostDTO to);
}
