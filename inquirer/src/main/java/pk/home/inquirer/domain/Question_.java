package pk.home.inquirer.domain;


import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Static metamodel for entity class: Question
 * Question - вопрос
 *
 */
@StaticMetamodel(Question.class)
public class Question_ {
	public static volatile SingularAttribute<Question, Long> id;
	public static volatile SingularAttribute<Question, String> keyName;
	public static volatile SingularAttribute<Question, String> description;
}
