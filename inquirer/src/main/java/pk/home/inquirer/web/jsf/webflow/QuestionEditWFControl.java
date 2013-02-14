package pk.home.inquirer.web.jsf.webflow;

import java.io.Serializable;

import pk.home.inquirer.domain.Answer;
import pk.home.inquirer.domain.Question;
import pk.home.inquirer.service.InquirerService;
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
	
	private Answer selectedAnswer;


	@Override
	public Question findEdited(Long id) throws Exception {
		return getQuestionService().findWithLazy(id);
	}
	
	public InquirerService getInquirerService() {
		return (InquirerService) findBean("inquirerService");
	}
	
	
	
	@Override
	public Question newEdited() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public Question newEdited(Long inquirerId) throws Exception {
		
		System.out.print(">>>>>>>>|>" + inquirerId);
		
		Question q = new  Question();
		q.setInquirer(getInquirerService().find(inquirerId));
		return q;
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
	
	
	// actions --------------------------------------------------------------------------------------
	
	public String addAnswer() {
		return "addAnswer";
	}
	
	
	public String editAnswer() {
		return "editAnswer";
	}
	
	
	public String delAnswer() {
		return "delAnswer";
	}


	

	// gets and sets
	// ---------------------------------------------------------------------------------------------------

	public Answer getSelectedAnswer() {
		return selectedAnswer;
	}
	
	
	public void setSelectedAnswer(Answer selectedAnswer) {
		this.selectedAnswer = selectedAnswer;
	}


	
	
	
	
	
	
}
