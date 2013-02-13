package pk.home.busterminal.dao.security;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pk.home.libs.combine.dao.ABaseDAO;
import pk.home.busterminal.domain.security.UserAuthority;


@Repository
@Transactional
public class UserAuthorityDAO extends ABaseDAO<UserAuthority>{

	@PersistenceContext(unitName = "")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	protected Class<UserAuthority> getTClass() {
		return UserAuthority.class;
	}

	@Override
	public Object getPrimaryKey(UserAuthority o) {
		return o.getId();
	}

}
