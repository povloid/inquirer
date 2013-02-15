package pk.home.inquirer.web.jsf.webflow;

import java.io.Serializable;

import pk.home.inquirer.domain.Rating;
import pk.home.inquirer.service.RatingService;
import pk.home.libs.combine.web.jsf.flow.AWFControl;

/**
 * JSF edit control class for entity class: Rating
 * Rating - рейтинг
 */
public class RatingEditWFControl extends AWFControl<Rating, Long> implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Rating findEdited(Long id) throws Exception {
		return getRatingService().find(id);
	}

	@Override
	public Rating newEdited() throws Exception {
		return new Rating();
	}

	public RatingService getRatingService() {
		return (RatingService) findBean("ratingService");
	}

	@Override
	protected void confirmAddImpl() throws Exception {
		edited = getRatingService().persist(edited);
	}

	@Override
	protected void confirmEditImpl() throws Exception {
		edited = getRatingService().merge(edited);
	}

	@Override
	protected void confirmDelImpl() throws Exception {
		getRatingService().remove(edited);
	}

	// init
	// ----------------------------------------------------------------------------------------------
	protected void init0() throws Exception {
	}

	// gets and sets
	// ---------------------------------------------------------------------------------------------------

}
