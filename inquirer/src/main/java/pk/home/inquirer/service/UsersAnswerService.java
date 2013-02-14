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
import pk.home.inquirer.dao.UsersAnswerDAO;
import pk.home.inquirer.domain.Inquirer;
import pk.home.inquirer.domain.UsersAnswer;
import pk.home.inquirer.domain.UsersAnswer_;

/**
 * Service class for entity class: UsersAnswer Users Answer - ответ пользователя
 */
@Service
@Transactional
public class UsersAnswerService extends ABaseService<UsersAnswer> {

	@Autowired
	private UsersAnswerDAO usersAnswerDAO;

	@Override
	public ABaseDAO<UsersAnswer> getAbstractBasicDAO() {
		return usersAnswerDAO;
	}

	@Transactional(readOnly = true)
	public List<UsersAnswer> getAllEntities(Inquirer inquirer, int firstResult,
			int maxResults, SingularAttribute<UsersAnswer, ?> orderByAttribute,
			SortOrderType sortOrder) throws Exception {

		CriteriaBuilder cb = usersAnswerDAO.getEntityManager()
				.getCriteriaBuilder();

		CriteriaQuery<UsersAnswer> cq = cb.createQuery(UsersAnswer.class);
		Root<UsersAnswer> t = cq.from(UsersAnswer.class);

		// parent param ---------------------------------------
		cq.where(cb.equal(t.get(UsersAnswer_.inquirer), inquirer));

		return usersAnswerDAO.getAllEntities(firstResult, maxResults,
				orderByAttribute, sortOrder, cb, cq, t);
	}

	@Transactional(readOnly = true)
	public List<UsersAnswer> getAllEntities(Inquirer inquirer) throws Exception {

		CriteriaBuilder cb = usersAnswerDAO.getEntityManager()
				.getCriteriaBuilder();

		CriteriaQuery<UsersAnswer> cq = cb.createQuery(UsersAnswer.class);
		Root<UsersAnswer> t = cq.from(UsersAnswer.class);

		// parent param ---------------------------------------
		cq.where(cb.equal(t.get(UsersAnswer_.inquirer), inquirer));

		return usersAnswerDAO.getAllEntities(UsersAnswer_.id,
				SortOrderType.ASC, cb, cq, t);
	}

	@Transactional(readOnly = true)
	public long count(Inquirer inquirer) throws Exception {

		CriteriaBuilder cb = usersAnswerDAO.getEntityManager()
				.getCriteriaBuilder();
		CriteriaQuery<Object> cq = usersAnswerDAO.getEntityManager()
				.getCriteriaBuilder().createQuery();
		Root<UsersAnswer> rt = cq.from(UsersAnswer.class);

		cq.where(cb.equal(rt.get(UsersAnswer_.inquirer), inquirer));

		cq.select(usersAnswerDAO.getEntityManager().getCriteriaBuilder()
				.count(rt));

		return (Long) usersAnswerDAO.getSinleResult(cq);
	}

}
