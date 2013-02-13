package pk.home.inquirer.web.jsf.webflow;

import java.io.Serializable;

import javax.persistence.metamodel.SingularAttribute;

import pk.home.inquirer.domain.Question;
import pk.home.inquirer.domain.Question_;
import pk.home.inquirer.service.QuestionService;
import pk.home.libs.combine.web.jsf.flow.AWFBaseLazyLoadTableView;

/**
 * JSF view control class for entity class: Question
 * Question - вопрос
 */
public class QuestionViewWFControl extends AWFBaseLazyLoadTableView<Question> implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QuestionService getQuestionService() {
		return (QuestionService) findBean("questionService");
	}

	@Override
	protected void aInit() throws Exception {
		
		SingularAttribute<Question, ?> orderByAttribute = Question_.id;
		if (csortField != null && csortField.equals("id")) {
			orderByAttribute = Question_.id;
		} else if (csortField != null && csortField.equals("keyName")) {
			orderByAttribute = Question_.keyName;
		}

		dataModel = getQuestionService().getAllEntities((page - 1) * rows, rows,
				orderByAttribute, getSortOrderType());
	}

	@Override
	protected long initAllRowsCount() throws Exception {		
		return getQuestionService().count();
	}
	
	
	public String add(){
		return "add";
	}
	
	public String edit(){
		return "edit";
	}
	
	public String del(){
		return "del";
	}
	
}
