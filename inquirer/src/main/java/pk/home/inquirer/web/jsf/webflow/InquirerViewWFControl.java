package pk.home.inquirer.web.jsf.webflow;

import java.io.Serializable;

import javax.persistence.metamodel.SingularAttribute;

import pk.home.inquirer.domain.Inquirer;
import pk.home.inquirer.domain.Inquirer_;
import pk.home.inquirer.service.InquirerService;
import pk.home.libs.combine.web.jsf.flow.AWFBaseLazyLoadTableView;

/**
 * JSF view control class for entity class: Inquirer
 * inquirer - опрос
 */
public class InquirerViewWFControl extends AWFBaseLazyLoadTableView<Inquirer> implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InquirerService getInquirerService() {
		return (InquirerService) findBean("inquirerService");
	}

	@Override
	protected void aInit() throws Exception {
		
		SingularAttribute<Inquirer, ?> orderByAttribute = Inquirer_.id;
		if (csortField != null && csortField.equals("id")) {
			orderByAttribute = Inquirer_.id;
		} else if (csortField != null && csortField.equals("keyName")) {
			orderByAttribute = Inquirer_.keyName;
		}

		dataModel = getInquirerService().getAllEntities((page - 1) * rows, rows,
				orderByAttribute, getSortOrderType());
	}

	@Override
	protected long initAllRowsCount() throws Exception {		
		return getInquirerService().count();
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
