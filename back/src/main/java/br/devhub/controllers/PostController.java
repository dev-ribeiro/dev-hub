package br.devhub.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.devhub.dto.PostDTO;
import br.devhub.dto.ResponseDTO;
import br.devhub.models.Post;
import br.devhub.services.PostService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "api/post")
@RequiredArgsConstructor
public class PostController {
	private final PostService postService;

	@PostMapping(path = "create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<Post>> createPost(@RequestBody PostDTO postDTO) throws ParseException {
		var result = new ResponseDTO<Post>(true, 1, postService.createPost(postDTO));
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PostMapping(path = "findall", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<List<Post>>> findAll(@RequestBody PostDTO postDTO) {
		var query = postService.findAll(postDTO);
		var result = new ResponseDTO<List<Post>>(true, query.size(), query);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}	
}
