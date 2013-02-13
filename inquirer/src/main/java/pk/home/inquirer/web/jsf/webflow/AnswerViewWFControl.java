package pk.home.inquirer.web.jsf.webflow;

import java.io.Serializable;

import javax.persistence.metamodel.SingularAttribute;

import pk.home.inquirer.domain.Answer;
import pk.home.inquirer.domain.Answer_;
import pk.home.inquirer.service.AnswerService;
import pk.home.libs.combine.web.jsf.flow.AWFBaseLazyLoadTableView;

/**
 * JSF view control class for entity class: Answer
 * Answer - ответ
 */
public class AnswerViewWFControl extends AWFBaseLazyLoadTableView<Answer> implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AnswerService getAnswerService() {
		return (AnswerService) findBean("answerService");
	}

	@Override
	protected void aInit() throws Exception {
		
		SingularAttribute<Answer, ?> orderByAttribute = Answer_.id;
		if (csortField != null && csortField.equals("id")) {
			orderByAttribute = Answer_.id;
		} else if (csortField != null && csortField.equals("keyName")) {
			orderByAttribute = Answer_.keyName;
		}

		dataModel = getAnswerService().getAllEntities((page - 1) * rows, rows,
				orderByAttribute, getSortOrderType());
	}

	@Override
	protected long initAllRowsCount() throws Exception {		
		return getAnswerService().count();
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
