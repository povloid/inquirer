package pk.home.inquirer.service;

import java.util.List;

import javax.persistence.metamodel.SingularAttribute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pk.home.inquirer.dao.InquirerDAO;
import pk.home.inquirer.domain.Inquirer;
import pk.home.inquirer.domain.Question;
import pk.home.inquirer.domain.security.UserAccount;
import pk.home.libs.combine.dao.ABaseDAO;
import pk.home.libs.combine.dao.ABaseDAO.SortOrderType;
import pk.home.libs.combine.service.ABaseService;

/**
 * Service class for entity class: Inquirer inquirer - опрос
 */
@Service
@Transactional
public class InquirerService extends ABaseService<Inquirer> {

	@Autowired
	private InquirerDAO inquirerDAO;
	
	@Autowired
	private RatingService ratingService;
	
	
	@Autowired
	private UsersAnswerService usersAnswerService;
	

	@Override
	public ABaseDAO<Inquirer> getAbstractBasicDAO() {
		return inquirerDAO;
	}

	/**
	 * Загрузка вместе с коллекциями
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public Inquirer findWithLazy(Object key) throws Exception {
		Inquirer inquirer = super.find(key);

		if (inquirer.getQuestions() != null) {
			inquirer.getQuestions().size();

			for (Question q : inquirer.getQuestions()) {
				if (q.getAnswers() != null)
					q.getAnswers().size();
			}
		}

		return inquirer;
	}
		
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Inquirer> getAllEntitiesWithAddInfo(UserAccount ua, int firstResult, int maxResults,
			SingularAttribute<Inquirer, ?> orderByAttribute,
			SortOrderType sortOrder) throws Exception {
		
		List<Inquirer> list = super.getAllEntities(firstResult, maxResults, orderByAttribute,
				sortOrder);
		
		for(Inquirer i: list){
			
			Object[] m = new Object[3];
			
			m[0] = usersAnswerService.isHaveUserAnswer(i, ua);
			m[1] = ratingService.isHaveUserAnswer(i, ua);
			m[2] = ratingService.getAVGRating(i);
			
			i.setAddInfo(m);
		}
		
		return list;
	}

	
	
	
	
	
	
	
		
	

}
