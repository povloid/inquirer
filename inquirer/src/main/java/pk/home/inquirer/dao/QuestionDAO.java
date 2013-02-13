package pk.home.inquirer.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pk.home.libs.combine.dao.ABaseDAO;
import pk.home.inquirer.domain.Question;


/**
 * DAO class for entity class: Question
 * Question - вопрос
 */
@Repository
@Transactional
public class QuestionDAO extends ABaseDAO<Question> {

	@Override
	protected Class<Question> getTClass() {
		return Question.class;
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
	public Object getPrimaryKey(Question o) {
		return o.getId();
	}

}
