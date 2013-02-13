package pk.home.inquirer.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pk.home.libs.combine.dao.ABaseDAO;
import pk.home.inquirer.domain.Inquirer;


/**
 * DAO class for entity class: Inquirer
 * inquirer - опрос
 */
@Repository
@Transactional
public class InquirerDAO extends ABaseDAO<Inquirer> {

	@Override
	protected Class<Inquirer> getTClass() {
		return Inquirer.class;
	}

	/**
	 * EntityManager injected by Spring for persistence unit
	 * 
	 */
	@PersistenceContext(unitName = "")
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Object getPrimaryKey(Inquirer o) {
		return o.getId();
	}

}
