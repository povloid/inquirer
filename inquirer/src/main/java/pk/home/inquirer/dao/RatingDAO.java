package pk.home.inquirer.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pk.home.libs.combine.dao.ABaseDAO;
import pk.home.inquirer.domain.Rating;


/**
 * DAO class for entity class: Rating
 * Rating - рейтинг
 */
@Repository
@Transactional
public class RatingDAO extends ABaseDAO<Rating> {

	@Override
	protected Class<Rating> getTClass() {
		return Rating.class;
	}

	/**
	 * EntityManager injected by Spring for persistence unit
	 * 
	 */
	@PersistenceContext(unitName = "")
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Object getPrimaryKey(Rating o) {
		return o.getId();
	}

}
