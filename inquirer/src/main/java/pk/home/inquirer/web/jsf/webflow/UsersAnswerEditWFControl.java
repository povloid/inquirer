package pk.home.inquirer.web.jsf.webflow;

import java.io.Serializable;

import pk.home.inquirer.domain.UsersAnswer;
import pk.home.inquirer.service.UsersAnswerService;
import pk.home.libs.combine.web.jsf.flow.AWFControl;

/**
 * JSF edit control class for entity class: UsersAnswer
 * Users Answer - ответ пользователя
 */
public class UsersAnswerEditWFControl extends AWFControl<UsersAnswer, Long> implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public UsersAnswer findEdited(Long id) throws Exception {
		return getUsersAnswerService().find(id);
	}

	@Override
	public UsersAnswer newEdited() throws Exception {
		return new UsersAnswer();
	}

	public UsersAnswerService getUsersAnswerService() {
		return (UsersAnswerService) findBean("usersAnswerService");
	}

	@Override
	protected void confirmAddImpl() throws Exception {
		edited = getUsersAnswerService().persist(edited);
	}

	@Override
	protected void confirmEditImpl() throws Exception {
		edited = getUsersAnswerService().merge(edited);
	}

	@Override
	protected void confirmDelImpl() throws Exception {
		getUsersAnswerService().remove(edited);
	}

	// init
	// ----------------------------------------------------------------------------------------------
	protected void init0() throws Exception {
	}

	// gets and sets
	// ---------------------------------------------------------------------------------------------------

}
