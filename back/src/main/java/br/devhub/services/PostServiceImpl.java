package br.devhub.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import br.devhub.dto.PostDTO;
import br.devhub.models.Post;
import br.devhub.repositories.PostRepository;
import lombok.RequiredArgsConstructor;

@Service
@Primary
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
	
	private final PostRepository postRepository;

	public Post createPost(PostDTO postDTO) {
		var entity = postDTO.toEntity();
		return postRepository.save(entity);
	}

}
