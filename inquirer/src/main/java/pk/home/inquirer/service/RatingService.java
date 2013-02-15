package pk.home.inquirer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pk.home.libs.combine.dao.ABaseDAO;
import pk.home.libs.combine.service.ABaseService;
import pk.home.inquirer.dao.RatingDAO;
import pk.home.inquirer.domain.Rating;

/**
 * Service class for entity class: Rating
 * Rating - рейтинг
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

}
