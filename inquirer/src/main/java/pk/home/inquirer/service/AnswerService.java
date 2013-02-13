package pk.home.inquirer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pk.home.libs.combine.dao.ABaseDAO;
import pk.home.libs.combine.service.ABaseService;
import pk.home.inquirer.dao.AnswerDAO;
import pk.home.inquirer.domain.Answer;
import pk.home.inquirer.domain.Question;

/**
 * Service class for entity class: Answer Answer - ответ
 */
@Service
@Transactional
public class AnswerService extends ABaseService<Answer> {

	@Autowired
	private AnswerDAO answerDAO;
	
	@Autowired
	private QuestionService questionService;

	@Override
	public ABaseDAO<Answer> getAbstractBasicDAO() {
		return answerDAO;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Answer persist(Answer o) throws Exception {

		Question q = questionService.findWithLazy(o.getQuestion().getId());
		
		if (q != null)
			o.setOrId(q.getAnswers().size());

		return super.persist(o);
	}

}
