package pk.home.inquirer.domain;


import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Static metamodel for entity class: Answer
 * Answer - ответ
 *
 */
@StaticMetamodel(Answer.class)
public class Answer_ {
	public static volatile SingularAttribute<Answer, Long> id;
	public static volatile SingularAttribute<Answer, String> keyName;
	public static volatile SingularAttribute<Answer, String> description;
	public static volatile SingularAttribute<Answer, Question> question;
}
