package pk.home.inquirer.domain;


import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Static metamodel for entity class: Inquirer
 * inquirer - опрос
 *
 */
@StaticMetamodel(Inquirer.class)
public class Inquirer_ {
	public static volatile SingularAttribute<Inquirer, Long> id;
	public static volatile SingularAttribute<Inquirer, String> keyName;
	public static volatile SingularAttribute<Inquirer, String> description;
}
