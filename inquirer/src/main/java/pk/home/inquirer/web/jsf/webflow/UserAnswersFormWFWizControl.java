package pk.home.inquirer.web.jsf.webflow;

import java.io.Serializable;

import pk.home.inquirer.domain.Inquirer;
import pk.home.inquirer.domain.Question;
import pk.home.inquirer.service.InquirerService;
import pk.home.libs.combine.web.jsf.flow.AWFWizart;

public class UserAnswersFormWFWizControl extends AWFWizart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2773606699398887519L;
	
	
	private Inquirer selectedInquirer;
	private int index = 1;
	private Question question;

	public void findInquirer(Long id) throws Exception{
		selectedInquirer = getInquirerService().findWithLazy(id);
	}
	
	
	public InquirerService getInquirerService() {
		return (InquirerService) findBean("inquirerService");
	}
	
	@Override
	protected void init0() throws Exception {
		initQuestion();
	}
	
	
	public void initQuestion() throws Exception {
		if(selectedInquirer != null 
				&& selectedInquirer.getQuestions() != null
				&& selectedInquirer.getQuestions().size() > 0)
			question = selectedInquirer.getQuestions().get(index - 1);
		else
			question = null;
	}
	
	
	@Override
	protected void nextImpl() throws Exception {
		++index;
	}
	
	@Override
	public void backImpl() {
		--index;
	}
	
	
	
	
	// gets and sets ---------------------------------------------------------------------------------------------------------
	



	public Inquirer getSelectedInquirer() {
		return selectedInquirer;
	}


	public void setSelectedInquirer(Inquirer selectedInquirer) {
		this.selectedInquirer = selectedInquirer;
	}


	public int getIndex() {
		return index;
	}


	public void setIndex(int index) {
		this.index = index;
	}


	public Question getQuestion() {
		return question;
	}


	public void setQuestion(Question question) {
		this.question = question;
	}
	
	
	
	
	
}
