package br.devhub.dto;

import br.devhub.models.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class UserDTO extends BaseDTO<User> {

	private static final long serialVersionUID = 3256082228322319163L;
	
	private String id;

    private String firstName;
    
    private String lastName;
    
    private String email;
    
    private String cellPhone;
    
    private String password;
    
    @Override
    public User toEntity() {
    	var entity = new User();
        entity.setId(id);
        entity.setFirstName(firstName);
        entity.setLastName(lastName);
        entity.setEmail(email);
        entity.setCellPhone(cellPhone);
        entity.setPassword(password);
    	return entity;
    }
}
