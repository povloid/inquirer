package pk.home.inquirer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pk.home.libs.combine.dao.ABaseDAO;
import pk.home.libs.combine.service.ABaseService;
import pk.home.inquirer.dao.UsersAnswerDAO;
import pk.home.inquirer.domain.UsersAnswer;

/**
 * Service class for entity class: UsersAnswer
 * Users Answer - ответ пользователя
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

}
