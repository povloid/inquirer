package pk.home.inquirer.web.jsf.webflow;

import java.io.Serializable;

import pk.home.inquirer.domain.Question;
import pk.home.inquirer.service.QuestionService;
import pk.home.libs.combine.web.jsf.flow.AWFControl;

/**
 * JSF edit control class for entity class: Question
 * Question - вопрос
 */
public class QuestionEditWFControl extends AWFControl<Question, Long> implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Question findEdited(Long id) throws Exception {
		return getQuestionService().find(id);
	}

	@Override
	public Question newEdited() throws Exception {
		return new Question();
	}

	public QuestionService getQuestionService() {
		return (QuestionService) findBean("questionService");
	}

	@Override
	protected void confirmAddImpl() throws Exception {
		edited = getQuestionService().persist(edited);
	}

	@Override
	protected void confirmEditImpl() throws Exception {
		edited = getQuestionService().merge(edited);
	}

	@Override
	protected void confirmDelImpl() throws Exception {
		getQuestionService().remove(edited);
	}

	// init
	// ----------------------------------------------------------------------------------------------
	protected void init0() throws Exception {
	}

	// gets and sets
	// ---------------------------------------------------------------------------------------------------

}
