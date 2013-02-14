package pk.home.inquirer.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pk.home.libs.combine.dao.ABaseDAO;
import pk.home.inquirer.domain.UsersAnswer;


/**
 * DAO class for entity class: UsersAnswer
 * Users Answer - ответ пользователя
 */
@Repository
@Transactional
public class UsersAnswerDAO extends ABaseDAO<UsersAnswer> {

	@Override
	protected Class<UsersAnswer> getTClass() {
		return UsersAnswer.class;
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
	public Object getPrimaryKey(UsersAnswer o) {
		return o.getId();
	}

}
