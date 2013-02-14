package pk.home.inquirer.web.jsf.webflow;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import pk.home.inquirer.domain.Answer;
import pk.home.inquirer.domain.Inquirer;
import pk.home.inquirer.domain.Question;
import pk.home.inquirer.service.InquirerService;
import pk.home.libs.combine.web.jsf.flow.AWFWizart;

public class UserAnswersFormWFWizControl extends AWFWizart implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2773606699398887519L;

	private Inquirer selectedInquirer;
	private int index = 1;
	private Question question;
	private Long answerId;
	private Map<Long,Long> qmap = new HashMap<>();
	

	public void findInquirer(Long id) throws Exception {
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
		if (selectedInquirer != null && selectedInquirer.getQuestions() != null
				&& selectedInquirer.getQuestions().size() > 0)
		{
			question = selectedInquirer.getQuestions().get(index - 1);
			answerId = qmap.get(question.getId());
		}	
		else
			question = null;
	}

	@Override
	public String next() {
		if ((index + 1) <= selectedInquirer.getQuestions().size()) {
			return super.next();
		} else {
			try {
				// TODO: Сделать формирование результата

			} catch (Exception e) {
				e.printStackTrace();
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Error: ", e.getMessage()));

				return "error";
			}

			return "end";
		}
	}

	@Override
	protected void nextImpl() throws Exception {
		qmap.put(question.getId(), answerId);
		
		++index;
	}

	@Override
	public void backImpl() {
		qmap.put(question.getId(), answerId);
		
		--index;
	}

	// gets and sets
	// ---------------------------------------------------------------------------------------------------------

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

	public Long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}

		
	
	
	
	

}
