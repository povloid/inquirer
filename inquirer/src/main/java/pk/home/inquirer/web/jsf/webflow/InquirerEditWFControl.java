package pk.home.inquirer.web.jsf.webflow;

import java.io.Serializable;

import pk.home.inquirer.domain.Inquirer;
import pk.home.inquirer.service.InquirerService;
import pk.home.libs.combine.web.jsf.flow.AWFControl;

/**
 * JSF edit control class for entity class: Inquirer
 * inquirer - опрос
 */
public class InquirerEditWFControl extends AWFControl<Inquirer, Long> implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Inquirer findEdited(Long id) throws Exception {
		return getInquirerService().find(id);
	}

	@Override
	public Inquirer newEdited() throws Exception {
		return new Inquirer();
	}

	public InquirerService getInquirerService() {
		return (InquirerService) findBean("inquirerService");
	}

	@Override
	protected void confirmAddImpl() throws Exception {
		edited = getInquirerService().persist(edited);
	}

	@Override
	protected void confirmEditImpl() throws Exception {
		edited = getInquirerService().merge(edited);
	}

	@Override
	protected void confirmDelImpl() throws Exception {
		getInquirerService().remove(edited);
	}

	// init
	// ----------------------------------------------------------------------------------------------
	protected void init0() throws Exception {
	}

	// gets and sets
	// ---------------------------------------------------------------------------------------------------

}
