package br.devhub.dto;

import java.util.Date;

import br.devhub.models.Post;
import br.devhub.models.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class PostDTO extends BaseDTO<Post> {
	
	private static final long serialVersionUID = 7166725456293960166L;

	private String id;
    private User user;
    private String title;
    private String description;
    private Date createdAt;
    private Date updatedAt;
    
    @Override
    public Post toEntity() {
    	var entity = new Post();
        entity.setId(id);
        entity.setTitle(title);
        entity.setDescription(description);
        entity.setCreatedAt(createdAt);
        entity.setUpdatedAt(updatedAt);
        entity.setUser(user);
    	return entity;
    }
}
