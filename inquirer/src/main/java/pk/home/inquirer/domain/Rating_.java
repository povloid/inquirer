package pk.home.inquirer.domain;


import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import pk.home.inquirer.domain.security.UserAccount;

/**
 * Static metamodel for entity class: Rating
 * Rating - рейтинг
 *
 */
@StaticMetamodel(Rating.class)
public class Rating_ {
	public static volatile SingularAttribute<Rating, Long> id;
	public static volatile SingularAttribute<Rating, String> description;
	public static volatile SingularAttribute<Rating, UserAccount> userAccount;
	public static volatile SingularAttribute<Rating, Inquirer> inquirer;
}
