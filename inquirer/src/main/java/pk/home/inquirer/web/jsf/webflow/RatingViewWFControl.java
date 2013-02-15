package pk.home.inquirer.web.jsf.webflow;

import java.io.Serializable;

import javax.persistence.metamodel.SingularAttribute;

import pk.home.inquirer.domain.Rating;
import pk.home.inquirer.domain.Rating_;
import pk.home.inquirer.service.RatingService;
import pk.home.libs.combine.web.jsf.flow.AWFBaseLazyLoadTableView;

/**
 * JSF view control class for entity class: Rating
 * Rating - рейтинг
 */
public class RatingViewWFControl extends AWFBaseLazyLoadTableView<Rating> implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RatingService getRatingService() {
		return (RatingService) findBean("ratingService");
	}

	@Override
	protected void aInit() throws Exception {
		
		SingularAttribute<Rating, ?> orderByAttribute = Rating_.id;
		if (csortField != null && csortField.equals("id")) {
			orderByAttribute = Rating_.id;
		} 
		
		dataModel = getRatingService().getAllEntities((page - 1) * rows, rows,
				orderByAttribute, getSortOrderType());
	}

	@Override
	protected long initAllRowsCount() throws Exception {		
		return getRatingService().count();
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
