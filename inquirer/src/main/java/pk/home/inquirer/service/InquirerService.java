package pk.home.inquirer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pk.home.libs.combine.dao.ABaseDAO;
import pk.home.libs.combine.service.ABaseService;
import pk.home.inquirer.dao.InquirerDAO;
import pk.home.inquirer.domain.Inquirer;

/**
 * Service class for entity class: Inquirer
 * inquirer - опрос
 */
@Service
@Transactional
public class InquirerService extends ABaseService<Inquirer> {

	@Autowired
	private InquirerDAO inquirerDAO;

	@Override
	public ABaseDAO<Inquirer> getAbstractBasicDAO() {
		return inquirerDAO;
	}

}
