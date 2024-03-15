package br.devhub.models;

import java.io.Serializable;
import java.util.Date;

import br.devhub.dto.UserDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pessoa", schema = "gestao")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
	
	private static final long serialVersionUID = 6907311257888517608L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	@Column(name = "primeiro_nome", nullable = false, length = 50)
    private String firstName;
    
	@Column(name = "sobrenome", nullable = false, length = 100)
    private String lastName;
    
	@Column(name = "email", nullable = false, length = 64, unique = true)
    private String email;
    
	@Column(name = "celular", nullable = true, length = 15)
    private String cellPhone;
    
	@Column(name = "senha", nullable = false, length = 50)
    private String password;
	
    public UserDTO toDTO() {
    	var userTO = new UserDTO();
    	userTO.setId(id);
    	userTO.setFirstName(firstName);
    	userTO.setLastName(lastName);
    	userTO.setEmail(email);
    	userTO.setCellPhone(cellPhone);
    	return userTO;
    }
}
