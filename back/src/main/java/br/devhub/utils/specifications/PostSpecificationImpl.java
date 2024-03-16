package br.devhub.utils.specifications;

import java.util.ArrayList;

import org.springframework.data.jpa.domain.Specification;

import br.devhub.dto.PostDTO;
import br.devhub.models.Post;
import br.devhub.models.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PostSpecificationImpl implements Specification<Post> {

	private static final long serialVersionUID = -5710585621407906977L;
	
	private final PostDTO criteria;

	@Override
	public Predicate toPredicate(Root<Post> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		var predicates = new ArrayList<Predicate>();

		Path<String> id = root.get("id");
		Path<User> user = root.get("user");

		if (criteria.getId() != null) {
			predicates.add(builder.equal(id, criteria.getId()));
		}

		if (criteria.getUser() != null) {
			predicates.add(builder.equal(user.get("id"), criteria.getUser().getId()));
		}

		return builder.and(predicates.toArray(new Predicate[0]));
	}

}
