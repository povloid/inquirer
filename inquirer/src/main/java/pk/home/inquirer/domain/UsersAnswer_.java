package pk.home.inquirer.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import pk.home.inquirer.domain.security.UserAccount;

/**
 * Static metamodel for entity class: UsersAnswer Users Answer - ответ
 * пользователя
 * 
 */
@StaticMetamodel(UsersAnswer.class)
public class UsersAnswer_ {
	public static volatile SingularAttribute<UsersAnswer, Long> id;
	public static volatile SingularAttribute<UsersAnswer, String> description;
	public static volatile SingularAttribute<UsersAnswer, UserAccount> userAccount;
	public static volatile SingularAttribute<UsersAnswer, Question> question;
	public static volatile SingularAttribute<UsersAnswer, Inquirer> inquirer;
	public static volatile SingularAttribute<UsersAnswer, Answer> answer;
}
