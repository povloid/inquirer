package pk.home.inquirer.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pk.home.libs.combine.dao.ABaseDAO;
import pk.home.libs.combine.dao.ABaseDAO.SortOrderType;
import pk.home.libs.combine.service.ABaseService;
import pk.home.inquirer.dao.QuestionDAO;
import pk.home.inquirer.domain.Inquirer;
import pk.home.inquirer.domain.Question;
import pk.home.inquirer.domain.Question_;

/**
 * Service class for entity class: Question Question - вопрос
 */
@Service
@Transactional
public class QuestionService extends ABaseService<Question> {

	@Autowired
	private QuestionDAO questionDAO;

	@Override
	public ABaseDAO<Question> getAbstractBasicDAO() {
		return questionDAO;
	}

	/**
	 * Загрузка вместе с коллекциями
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public Question findWithLazy(Object key) throws Exception {
		Question question = super.find(key);

		if (question.getAnswers() != null) {
			question.getAnswers().size();
		}

		return question;
	}

	@Transactional(readOnly = true)
	public List<Question> getAllEntities(Inquirer inquirer, int firstResult,
			int maxResults, SingularAttribute<Question, ?> orderByAttribute,
			SortOrderType sortOrder) throws Exception {

		CriteriaBuilder cb = questionDAO.getEntityManager()
				.getCriteriaBuilder();

		CriteriaQuery<Question> cq = cb.createQuery(Question.class);
		Root<Question> t = cq.from(Question.class);

		// parent param ---------------------------------------
		cq.where(cb.equal(t.get(Question_.inquirer), inquirer));

		return questionDAO.getAllEntities(firstResult, maxResults,
				orderByAttribute, sortOrder, cb, cq, t);
	}

	@Transactional(readOnly = true)
	public List<Question> getAllEntities(Inquirer inquirer) throws Exception {

		CriteriaBuilder cb = questionDAO.getEntityManager()
				.getCriteriaBuilder();

		CriteriaQuery<Question> cq = cb.createQuery(Question.class);
		Root<Question> t = cq.from(Question.class);

		// parent param ---------------------------------------
		cq.where(cb.equal(t.get(Question_.inquirer), inquirer));

		return questionDAO.getAllEntities(Question_.keyName, SortOrderType.ASC,
				cb, cq, t);
	}

	@Transactional(readOnly = true)
	public long count(Inquirer inquirer) throws Exception {

		CriteriaBuilder cb = questionDAO.getEntityManager()
				.getCriteriaBuilder();
		CriteriaQuery<Object> cq = questionDAO.getEntityManager()
				.getCriteriaBuilder().createQuery();
		Root<Question> rt = cq.from(Question.class);

		cq.where(cb.equal(rt.get(Question_.inquirer), inquirer));

		cq.select(questionDAO.getEntityManager().getCriteriaBuilder().count(rt));

		return (Long) questionDAO.getSinleResult(cq);
	}

}
