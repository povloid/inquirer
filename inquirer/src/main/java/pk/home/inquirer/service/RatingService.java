package pk.home.inquirer.service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pk.home.libs.combine.dao.ABaseDAO;
import pk.home.libs.combine.service.ABaseService;
import pk.home.inquirer.dao.RatingDAO;
import pk.home.inquirer.domain.Inquirer;
import pk.home.inquirer.domain.Rating;
import pk.home.inquirer.domain.Rating_;
import pk.home.inquirer.domain.security.UserAccount;

/**
 * Service class for entity class: Rating Rating - рейтинг
 */
@Service
@Transactional
public class RatingService extends ABaseService<Rating> {

	@Autowired
	private RatingDAO ratingDAO;

	@Override
	public ABaseDAO<Rating> getAbstractBasicDAO() {
		return ratingDAO;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public boolean isHaveUserAnswer(Inquirer inquirer, UserAccount ua)
			throws Exception {

		CriteriaBuilder cb = ratingDAO.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Object> cq = ratingDAO.getEntityManager()
				.getCriteriaBuilder().createQuery();
		Root<Rating> rt = cq.from(Rating.class);

		cq.where(cb.and(cb.equal(rt.get(Rating_.inquirer), inquirer),
				cb.equal(rt.get(Rating_.userAccount), ua)));

		cq.select(ratingDAO.getEntityManager().getCriteriaBuilder()
				.max(rt.get(Rating_.id)));

		return (Long) ratingDAO.getSinleResult(cq) != null;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public int getAVGRating(Inquirer inquirer) throws Exception {

		CriteriaBuilder cb = ratingDAO.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Object> cq = ratingDAO.getEntityManager()
				.getCriteriaBuilder().createQuery();
		Root<Rating> rt = cq.from(Rating.class);

		cq.where(cb.and(cb.equal(rt.get(Rating_.inquirer), inquirer)));

		cq.select(ratingDAO.getEntityManager().getCriteriaBuilder()
				.avg(rt.get(Rating_.val)));

		Double ratVal = (Double) ratingDAO.getSinleResult(cq);

		return ratVal != null ? ratVal.intValue() : 0;

	}

}
