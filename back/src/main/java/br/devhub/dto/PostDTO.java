package br.devhub.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    private String createdAt;
    private String updatedAt;
    
    @Override
    public Post toEntity() throws ParseException {
    	var isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    	var entity = new Post();
        entity.setId(id);
        entity.setTitle(title);
        entity.setDescription(description);
        entity.setCreatedAt(isoFormat.parse(createdAt));
        entity.setUpdatedAt(isoFormat.parse(updatedAt));
        entity.setUser(user);
    	return entity;
    }
}
