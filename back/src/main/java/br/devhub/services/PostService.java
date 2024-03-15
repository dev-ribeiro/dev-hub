package br.devhub.services;

import br.devhub.dto.PostDTO;
import br.devhub.models.Post;

public interface PostService {
	Post createPost(PostDTO to);
}
