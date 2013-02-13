package pk.home.inquirer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pk.home.libs.combine.dao.ABaseDAO;
import pk.home.libs.combine.service.ABaseService;
import pk.home.inquirer.dao.AnswerDAO;
import pk.home.inquirer.domain.Answer;

/**
 * Service class for entity class: Answer
 * Answer - ответ
 */
@Service
@Transactional
public class AnswerService extends ABaseService<Answer> {

	@Autowired
	private AnswerDAO answerDAO;

	@Override
	public ABaseDAO<Answer> getAbstractBasicDAO() {
		return answerDAO;
	}

}
