package pk.home.inquirer.web.jsf.webflow;

import java.io.Serializable;

import javax.persistence.metamodel.SingularAttribute;

import pk.home.inquirer.domain.Inquirer;
import pk.home.inquirer.domain.Inquirer_;
import pk.home.inquirer.domain.Rating;
import pk.home.inquirer.service.InquirerService;
import pk.home.inquirer.service.RatingService;
import pk.home.inquirer.web.jsf.security.TerminalCurrentUser;
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
	
	private int rating;

	public InquirerService getInquirerService() {
		return (InquirerService) findBean("inquirerService");
	}

	public TerminalCurrentUser getTerminalCurrentUser() {
		return (TerminalCurrentUser) findBean("terminalCurrentUser");
	}
	
	
	public RatingService getRatingService() {
		return (RatingService) findBean("ratingService");
	}
	
	
	@Override
	protected void aInit() throws Exception {
		
		SingularAttribute<Inquirer, ?> orderByAttribute = Inquirer_.id;
		if (csortField != null && csortField.equals("id")) {
			orderByAttribute = Inquirer_.id;
		} else if (csortField != null && csortField.equals("keyName")) {
			orderByAttribute = Inquirer_.keyName;
		}

		dataModel = getInquirerService().getAllEntitiesWithAddInfo(
				getTerminalCurrentUser().getUserAccount()
				, (page - 1) * rows, rows,
				orderByAttribute, getSortOrderType());
	}

	@Override
	protected long initAllRowsCount() throws Exception {		
		return getInquirerService().count();
	}
	
	public void setRating() throws Exception{
		
		Rating r = new Rating();
		
		r.setInquirer(selected);
		r.setUserAccount(getTerminalCurrentUser().getUserAccount());
		r.setVal(rating);
		
		getRatingService().persist(r);
		
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	
	
	
	
}
