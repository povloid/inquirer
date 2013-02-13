package pk.home.inquirer.web.jsf.webflow;

import java.io.Serializable;

import pk.home.inquirer.domain.Answer;
import pk.home.inquirer.service.AnswerService;
import pk.home.inquirer.service.QuestionService;
import pk.home.libs.combine.web.jsf.flow.AWFControl;

/**
 * JSF edit control class for entity class: Answer
 * Answer - ответ
 */
public class AnswerEditWFControl extends AWFControl<Answer, Long> implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long questionId;

	@Override
	public Answer findEdited(Long id) throws Exception {
		
		System.out.println("id>>>" + id);
		
		return getAnswerService().find(id);
	}

	@Override
	public Answer newEdited() throws Exception {
		return new Answer();
	}

	public AnswerService getAnswerService() {
		return (AnswerService) findBean("answerService");
	}
	
	public QuestionService getQuestionService() {
		return (QuestionService) findBean("questionService");
	}
	

	@Override
	protected void confirmAddImpl() throws Exception {
		edited.setQuestion(getQuestionService().find(questionId));
		edited = getAnswerService().persist(edited);
	}

	@Override
	protected void confirmEditImpl() throws Exception {
		edited = getAnswerService().merge(edited);
	}

	@Override
	protected void confirmDelImpl() throws Exception {
		getAnswerService().remove(edited);
	}

	// init
	// ----------------------------------------------------------------------------------------------
	protected void init0() throws Exception {
	}

	// gets and sets
	// ---------------------------------------------------------------------------------------------------

	public long getQuestionId() {
		return questionId;
	}
	
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	
	
	
	
	
	
	
}
