package br.devhub.services;

import java.text.ParseException;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.devhub.dto.PostDTO;
import br.devhub.models.Post;
import br.devhub.repositories.PostRepository;
import br.devhub.utils.specifications.PostSpecificationImpl;
import lombok.RequiredArgsConstructor;

@Service
@Primary
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
	private final PostRepository postRepository;

	public Post createPost(PostDTO postDTO) throws ParseException {
		var entity = postDTO.toEntity();
		return postRepository.save(entity);
	}

	public List<Post> findAll(PostDTO postDTO) {
		var pageable = PageRequest.of(postDTO.getPage() - 1, postDTO.getSize(),
				Sort.by(postDTO.getDirection(), postDTO.getBy()));
		var postSpecification = new PostSpecificationImpl(postDTO);
		var query = postRepository.findAll(postSpecification, pageable);
		return query.getContent();
	}

}
