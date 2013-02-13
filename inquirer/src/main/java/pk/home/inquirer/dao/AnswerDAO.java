package pk.home.inquirer.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pk.home.libs.combine.dao.ABaseDAO;
import pk.home.inquirer.domain.Answer;


/**
 * DAO class for entity class: Answer
 * Answer - ответ
 */
@Repository
@Transactional
public class AnswerDAO extends ABaseDAO<Answer> {

	@Override
	protected Class<Answer> getTClass() {
		return Answer.class;
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
	public Object getPrimaryKey(Answer o) {
		return o.getId();
	}

}
