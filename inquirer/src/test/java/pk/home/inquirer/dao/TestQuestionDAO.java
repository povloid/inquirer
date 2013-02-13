package pk.home.inquirer.dao;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import pk.home.inquirer.domain.Question;
import pk.home.inquirer.domain.Question_;
import pk.home.libs.combine.dao.ABaseDAO.SortOrderType;

/**
 * JUnit test DAO class for entity class: Question
 * Question - вопрос
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
@Transactional
@ContextConfiguration(locations = { "file:./src/main/resources/applicationContext.xml" })
public class TestQuestionDAO {

	/**
	 * The DAO being tested, injected by Spring
	 * 
	 */
	private QuestionDAO dataStore;

	/**
	 * Method to allow Spring to inject the DAO that will be tested
	 * 
	 */
	@Autowired
	public void setDataStore(QuestionDAO dataStore) {
		this.dataStore = dataStore;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link pk.home.libs.combine.dao.ABaseDAO#getAllEntities()}.
	 * 
	 * @throws Exception
	 */
	@Test
	@Rollback(true)
	public void testGetAllEntities() throws Exception {

		long index = dataStore.count();
		for (int i = 0; i < 100; i++) {
			Question question = new Question();
			question.setKeyName("key " + i);
			dataStore.persist(question);
			index++;
		}

		List<Question> list = dataStore.getAllEntities();

		assertTrue(list != null);
		assertTrue(list.size() > 0);
		assertTrue(list.size() == index);
	}

	/**
	 * Test method for
	 * {@link pk.home.libs.combine.dao.ABaseDAO#getAllEntities(javax.persistence.metamodel.SingularAttribute, pk.home.libs.combine.dao.ABaseDAO.SortOrderType)}
	 * .
	 * 
	 * @throws Exception
	 */
	@Test
	@Rollback(true)
	public void testGetAllEntitiesSingularAttributeOfTQSortOrderType()
			throws Exception {
		long index = dataStore.count();
		for (int i = 0; i < 100; i++) {
			Question question = new Question();
			question.setKeyName("key " + i);
			dataStore.persist(question);
			index++;
		}

		List<Question> list = dataStore.getAllEntities(Question_.id, SortOrderType.ASC);

		assertTrue(list != null);
		assertTrue(list.size() > 0);
		assertTrue(list.size() == index);

		long lastId = 0;
		for (Question question : list) {
			assertTrue(lastId < question.getId());
			lastId = question.getId();
		}
	}

	/**
	 * Test method for
	 * {@link pk.home.libs.combine.dao.ABaseDAO#getAllEntities(int, int)}.
	 * 
	 * @throws Exception
	 */
	@Test
	@Rollback(true)
	public void testGetAllEntitiesIntInt() throws Exception {

		// int index = 0;
		for (int i = 0; i < 100; i++) {
			Question question = new Question();
			question.setKeyName("key " + i);
			dataStore.persist(question);
			// index++;
		}

		List<Question> list = dataStore.getAllEntities(10, 10);

		assertTrue(list != null);
		assertTrue(list.size() > 0);
		assertTrue(list.size() == 10);
	}

	/**
	 * Test method for
	 * {@link pk.home.libs.combine.dao.ABaseDAO#getAllEntities(int, int, javax.persistence.metamodel.SingularAttribute, pk.home.libs.combine.dao.ABaseDAO.SortOrderType)}
	 * .
	 * 
	 * @throws Exception
	 */
	@Test
	@Rollback(true)
	public void testGetAllEntitiesIntIntSingularAttributeOfTQSortOrderType()
			throws Exception {
		// long index = dataStore.count();
		for (int i = 0; i < 100; i++) {
			Question question = new Question();
			question.setKeyName("key " + i);
			dataStore.persist(question);
			// index++;
		}

		List<Question> list = dataStore.getAllEntities(10, 10, Question_.id,
				SortOrderType.ASC);

		assertTrue(list != null);
		assertTrue(list.size() > 0);
		assertTrue(list.size() == 10);

		long lastId = 0;
		for (Question question : list) {
			assertTrue(lastId < question.getId());
			lastId = question.getId();
		}
	}

	/**
	 * Test method for
	 * {@link pk.home.libs.combine.dao.ABaseDAO#getAllEntities(boolean, int, int, javax.persistence.metamodel.SingularAttribute, pk.home.libs.combine.dao.ABaseDAO.SortOrderType)}
	 * .
	 * 
	 * @throws Exception
	 */
	@Test
	@Rollback(true)
	public void testGetAllEntitiesBooleanIntIntSingularAttributeOfTQSortOrderType()
			throws Exception {
		long index = dataStore.count();
		for (int i = 0; i < 100; i++) {
			Question question = new Question();
			question.setKeyName("key " + i);
			dataStore.persist(question);
			index++;
		}

		// all - FALSE
		List<Question> list = dataStore.getAllEntities(false, 10, 10, Question_.id,
				SortOrderType.ASC);

		assertTrue(list != null);
		assertTrue(list.size() > 0);
		assertTrue(list.size() == 10);

		long lastId = 0;
		for (Question question : list) {
			assertTrue(lastId < question.getId());
			lastId = question.getId();
		}

		// all - TRUE
		list = dataStore.getAllEntities(true, 10, 10, Question_.id,
				SortOrderType.ASC);

		assertTrue(list != null);
		assertTrue(list.size() > 0);
		assertTrue(list.size() == index);

		lastId = 0;
		for (Question question : list) {
			assertTrue(lastId < question.getId());
			lastId = question.getId();
		}
	}

	/**
	 * Test method for
	 * {@link pk.home.libs.combine.dao.ABaseDAO#find(java.lang.Object)}.
	 * 
	 * @throws Exception
	 */
	@Test
	@Rollback(true)
	public void testFind() throws Exception {

		Question question = new Question();
		question.setKeyName("key " + 999);
		question = dataStore.persist(question);

		long id = question.getId();

		Question question2 = dataStore.find(id);

		assertEquals(question, question2);
		assertTrue(question.getId() == question2.getId());
		assertEquals(question.getKeyName(), question2.getKeyName());

	}

	/**
	 * Test method for {@link pk.home.libs.combine.dao.ABaseDAO#count()}.
	 * 
	 * @throws Exception
	 */
	@Test
	@Rollback(true)
	public void testCount() throws Exception {
		long index = dataStore.count();
		for (int i = 0; i < 100; i++) {
			Question question = new Question();
			question.setKeyName("key " + i);
			dataStore.persist(question);
			index++;
		}

		long count = dataStore.count();

		assertTrue(count == index);
	}

	/**
	 * Test method for
	 * {@link pk.home.libs.combine.dao.ABaseDAO#persist(java.lang.Object)}.
	 * 
	 * @throws Exception
	 */
	@Test
	@Rollback(true)
	public void testPersist() throws Exception {
		Question question = new Question();
		question.setKeyName("key " + 999);
		question = dataStore.persist(question);

		long id = question.getId();

		Question question2 = dataStore.find(id);

		assertEquals(question, question2);
		assertTrue(question.getId() == question2.getId());
		assertEquals(question.getKeyName(), question2.getKeyName());
	}

	/**
	 * Test method for
	 * {@link pk.home.libs.combine.dao.ABaseDAO#refresh(java.lang.Object)}.
	 * 
	 * @throws Exception
	 */
	@Test
	@Rollback(true)
	public void testRefresh() throws Exception {
		Question question = new Question();
		question.setKeyName("key " + 999);
		question = dataStore.persist(question);

		long id = question.getId();

		Question question2 = dataStore.find(id);

		assertEquals(question, question2);
		assertTrue(question.getId() == question2.getId());
		assertEquals(question.getKeyName(), question2.getKeyName());

		question2.setKeyName("key 65535");
		question2 = dataStore.refresh(question2);

		assertEquals(question, question2);
		assertTrue(question.getId() == question2.getId());
		assertEquals(question.getKeyName(), question2.getKeyName());

	}

	/**
	 * Test method for
	 * {@link pk.home.libs.combine.dao.ABaseDAO#merge(java.lang.Object)}.
	 * 
	 * @throws Exception
	 */
	@Test
	@Rollback(true)
	public void testMerge() throws Exception {
		Question question = new Question();
		question.setKeyName("key " + 999);
		question = dataStore.persist(question);

		long id = question.getId();

		Question question2 = dataStore.find(id);

		assertEquals(question, question2);
		assertTrue(question.getId() == question2.getId());
		assertEquals(question.getKeyName(), question2.getKeyName());

		question2.setKeyName("key 65535");
		question2 = dataStore.merge(question2);

		question = dataStore.refresh(question);

		assertEquals(question, question2);
		assertTrue(question.getId() == question2.getId());
		assertEquals(question.getKeyName(), question2.getKeyName());
	}

	/**
	 * Test method for
	 * {@link pk.home.libs.combine.dao.ABaseDAO#remove(java.lang.Object)}.
	 * 
	 * @throws Exception
	 */
	@Test
	@Rollback(true)
	public void testRemove() throws Exception {
		Question question = new Question();
		question.setKeyName("key " + 999);
		question = dataStore.persist(question);

		long id = question.getId();

		Question question2 = dataStore.find(id);

		assertEquals(question, question2);
		assertTrue(question.getId() == question2.getId());
		assertEquals(question.getKeyName(), question2.getKeyName());

		dataStore.remove(question);

		Question question3 = dataStore.find(id);
		assertTrue(question3 == null);

	}
	
	
	
	// -----------------------------------------------------------------------------------------------------------------
	
	@Test
	@Rollback(true)
	public void insertEntities() throws Exception {

		long index = dataStore.count();
		for (int i = 200; i < 210; i++) {
			Question question = new Question();
			question.setKeyName("key " + i);
			dataStore.persist(question);
			index++;
		}

		List<Question> list = dataStore.getAllEntities();

		assertTrue(list != null);
		assertTrue(list.size() > 0);
		assertTrue(list.size() == index);
	}
	

}
