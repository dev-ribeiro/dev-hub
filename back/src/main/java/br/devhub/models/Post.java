package br.devhub.models;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "posts", schema = "negocio")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post implements Serializable {
	
	private static final long serialVersionUID = -494215410455052877L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
    
	@ManyToOne
	@JoinColumn(name = "id_pessoa", referencedColumnName = "id")
    private User user;
    
	@Column(name = "titulo", nullable = false, length = 50)
    private String title;
    
	@Column(name = "conteudo", nullable = false, length = 500)
    private String description;
    
	@Column(name = "data_criacao", nullable = false)
    private Date createdAt;
    
	@Column(name = "data_atualizacao", nullable = false)
    private Date updatedAt;
}
