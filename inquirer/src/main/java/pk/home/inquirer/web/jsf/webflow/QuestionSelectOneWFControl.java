package pk.home.inquirer.web.jsf.webflow;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.model.SortOrder;

import pk.home.inquirer.domain.Question;
import pk.home.inquirer.service.QuestionService;
import pk.home.libs.combine.web.jsf.flow.AWFBasicControl;
import pk.home.libs.combine.web.jsf.flow.model.WFLazyDataModel;

public class QuestionSelectOneWFControl extends AWFBasicControl implements
		Serializable {

	public QuestionService getQuestionService() {
		return (QuestionService) findBean("questionService");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -6986222423369826350L;

	private Question selected;

	private WFLazyDataModel<Question> model = new WFLazyDataModel<Question>() {

		/**
		 * 
		 */
		private static final long serialVersionUID = 4970282896915525138L;
		
		@Override
		protected int count(Map<String, String> filters) throws Exception {
			return (int) getQuestionService().count();
		}

		@Override
		protected List<Question> aload(int first, int pageSize,
				String sortField, SortOrder sortOrder,
				Map<String, String> filters) throws Exception {
			return getQuestionService().getAllEntities(first, pageSize);
		}

		@Override
		public Question getRowData(String rowKey) {
			for (Question rd : getDataList()) {
				if (rd.getId() == Long.parseLong(rowKey))
					return rd;
			}
			return null;
		}

		@Override
		public Object getRowKey(Question object) {
			return object.getId();
		}
	};

	// actions
	// -----------------------------------------------------------------------------------------

	/**
	 * Выбор остановки
	 * 
	 * @return
	 * @throws Exception
	 */
	public String select() throws Exception {

		if (selected == null) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ",
							"Элемент небыл выбран"));
			throw new Exception("Элемент небыл выбран");
		}

		return "select";
	}

	// get's and set's
	// -------------------------------------------------------------------------------------------------

	public Question getSelected() {
		return selected;
	}

	public void setSelected(Question selected) {
		this.selected = selected;
	}

	public WFLazyDataModel<Question> getModel() {
		return model;
	}

	public void setModel(WFLazyDataModel<Question> model) {
		this.model = model;
	}

	public Long getSelectedId() {
		if (selected != null)
			return selected.getId();
		else
			return null;
	}

}
