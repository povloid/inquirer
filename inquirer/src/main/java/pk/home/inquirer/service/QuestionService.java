package pk.home.inquirer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pk.home.libs.combine.dao.ABaseDAO;
import pk.home.libs.combine.service.ABaseService;
import pk.home.inquirer.dao.QuestionDAO;
import pk.home.inquirer.domain.Question;

/**
 * Service class for entity class: Question
 * Question - вопрос
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

}
