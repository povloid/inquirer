package pk.home.inquirer.web.jsf.webflow;

import java.io.Serializable;

import javax.persistence.metamodel.SingularAttribute;

import pk.home.inquirer.domain.UsersAnswer;
import pk.home.inquirer.domain.UsersAnswer_;
import pk.home.inquirer.service.UsersAnswerService;
import pk.home.libs.combine.web.jsf.flow.AWFBaseLazyLoadTableView;

/**
 * JSF view control class for entity class: UsersAnswer
 * Users Answer - ответ пользователя
 */
public class UsersAnswerViewWFControl extends AWFBaseLazyLoadTableView<UsersAnswer> implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsersAnswerService getUsersAnswerService() {
		return (UsersAnswerService) findBean("usersAnswerService");
	}

	@Override
	protected void aInit() throws Exception {
		
		SingularAttribute<UsersAnswer, ?> orderByAttribute = UsersAnswer_.id;
		if (csortField != null && csortField.equals("id")) {
			orderByAttribute = UsersAnswer_.id;
		} 
		
		dataModel = getUsersAnswerService().getAllEntities((page - 1) * rows, rows,
				orderByAttribute, getSortOrderType());
	}

	@Override
	protected long initAllRowsCount() throws Exception {		
		return getUsersAnswerService().count();
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
