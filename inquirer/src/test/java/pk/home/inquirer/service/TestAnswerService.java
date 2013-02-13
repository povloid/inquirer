package pk.home.inquirer.service;

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
import pk.home.inquirer.domain.Answer;
import pk.home.inquirer.domain.Answer_;
import pk.home.libs.combine.dao.ABaseDAO.SortOrderType;

/**
 * JUnit test service class for entity class: Answer
 * Answer - ответ
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
@Transactional
@ContextConfiguration(locations = { "file:./src/main/resources/applicationContext.xml" })
public class TestAnswerService {

	/**
	 * The DAO being tested, injected by Spring
	 * 
	 */
	private AnswerService service;

	/**
	 * Method to allow Spring to inject the DAO that will be tested
	 * 
	 */
	@Autowired
	public void setDataStore(AnswerService service) {
		this.service = service;
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

		long index = service.count();
		for (int i = 0; i < 100; i++) {
			Answer answer = new Answer();
			answer.setKeyName("key " + i);
			service.persist(answer);
			index++;
		}

		List<Answer> list = service.getAllEntities();

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
		long index = service.count();
		for (int i = 0; i < 100; i++) {
			Answer answer = new Answer();
			answer.setKeyName("key " + i);
			service.persist(answer);
			index++;
		}

		List<Answer> list = service.getAllEntities(Answer_.id, SortOrderType.ASC);

		assertTrue(list != null);
		assertTrue(list.size() > 0);
		assertTrue(list.size() == index);

		long lastId = 0;
		for (Answer answer : list) {
			assertTrue(lastId < answer.getId());
			lastId = answer.getId();
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
			Answer answer = new Answer();
			answer.setKeyName("key " + i);
			service.persist(answer);
			// index++;
		}

		List<Answer> list = service.getAllEntities(10, 10);

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
		// long index = service.count();
		for (int i = 0; i < 100; i++) {
			Answer answer = new Answer();
			answer.setKeyName("key " + i);
			service.persist(answer);
			// index++;
		}

		List<Answer> list = service.getAllEntities(10, 10, Answer_.id,
				SortOrderType.ASC);

		assertTrue(list != null);
		assertTrue(list.size() > 0);
		assertTrue(list.size() == 10);

		long lastId = 0;
		for (Answer answer : list) {
			assertTrue(lastId < answer.getId());
			lastId = answer.getId();
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
		long index = service.count();
		for (int i = 0; i < 100; i++) {
			Answer answer = new Answer();
			answer.setKeyName("key " + i);
			service.persist(answer);
			index++;
		}

		// all - FALSE
		List<Answer> list = service.getAllEntities(false, 10, 10, Answer_.id,
				SortOrderType.ASC);

		assertTrue(list != null);
		assertTrue(list.size() > 0);
		assertTrue(list.size() == 10);

		long lastId = 0;
		for (Answer answer : list) {
			assertTrue(lastId < answer.getId());
			lastId = answer.getId();
		}

		// all - TRUE
		list = service.getAllEntities(true, 10, 10, Answer_.id,
				SortOrderType.ASC);

		assertTrue(list != null);
		assertTrue(list.size() > 0);
		assertTrue(list.size() == index);

		lastId = 0;
		for (Answer answer : list) {
			assertTrue(lastId < answer.getId());
			lastId = answer.getId();
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

		Answer answer = new Answer();
		answer.setKeyName("key " + 999);
		answer = service.persist(answer);

		long id = answer.getId();

		Answer answer2 = service.find(id);

		assertEquals(answer, answer2);
		assertTrue(answer.getId() == answer2.getId());
		assertEquals(answer.getKeyName(), answer2.getKeyName());

	}

	/**
	 * Test method for {@link pk.home.libs.combine.dao.ABaseDAO#count()}.
	 * 
	 * @throws Exception
	 */
	@Test
	@Rollback(true)
	public void testCount() throws Exception {
		long index = service.count();
		for (int i = 0; i < 100; i++) {
			Answer answer = new Answer();
			answer.setKeyName("key " + i);
			service.persist(answer);
			index++;
		}

		long count = service.count();

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
		Answer answer = new Answer();
		answer.setKeyName("key " + 999);
		answer = service.persist(answer);

		long id = answer.getId();

		Answer answer2 = service.find(id);

		assertEquals(answer, answer2);
		assertTrue(answer.getId() == answer2.getId());
		assertEquals(answer.getKeyName(), answer2.getKeyName());
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
		Answer answer = new Answer();
		answer.setKeyName("key " + 999);
		answer = service.persist(answer);

		long id = answer.getId();

		Answer answer2 = service.find(id);

		assertEquals(answer, answer2);
		assertTrue(answer.getId() == answer2.getId());
		assertEquals(answer.getKeyName(), answer2.getKeyName());

		answer2.setKeyName("key 65535");
		answer2 = service.refresh(answer2);

		assertEquals(answer, answer2);
		assertTrue(answer.getId() == answer2.getId());
		assertEquals(answer.getKeyName(), answer2.getKeyName());

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
		Answer answer = new Answer();
		answer.setKeyName("key " + 999);
		answer = service.persist(answer);

		long id = answer.getId();

		Answer answer2 = service.find(id);

		assertEquals(answer, answer2);
		assertTrue(answer.getId() == answer2.getId());
		assertEquals(answer.getKeyName(), answer2.getKeyName());

		answer2.setKeyName("key 65535");
		answer2 = service.merge(answer2);

		answer = service.refresh(answer);

		assertEquals(answer, answer2);
		assertTrue(answer.getId() == answer2.getId());
		assertEquals(answer.getKeyName(), answer2.getKeyName());
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
		Answer answer = new Answer();
		answer.setKeyName("key " + 999);
		answer = service.persist(answer);

		long id = answer.getId();

		Answer answer2 = service.find(id);

		assertEquals(answer, answer2);
		assertTrue(answer.getId() == answer2.getId());
		assertEquals(answer.getKeyName(), answer2.getKeyName());

		service.remove(answer);

		Answer answer3 = service.find(id);
		assertTrue(answer3 == null);

	}
	
	
	
	// -----------------------------------------------------------------------------------------------------------------
	
	@Test
	@Rollback(true)
	public void insertEntities() throws Exception {

		long index = service.count();
		for (int i = 200; i < 210; i++) {
			Answer answer = new Answer();
			answer.setKeyName("key " + i);
			service.persist(answer);
			index++;
		}

		List<Answer> list = service.getAllEntities();

		assertTrue(list != null);
		assertTrue(list.size() > 0);
		assertTrue(list.size() == index);
	}
	

}
