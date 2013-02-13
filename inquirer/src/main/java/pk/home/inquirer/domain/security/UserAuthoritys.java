package pk.home.inquirer.domain.security;

/**
 * Список ролей
 * 
 * @author povloid
 * 
 */
public enum UserAuthoritys {
	ROLE_SUPERUSER, 	// Суперпользователь
	ROLE_ADMIN, 		// Администратор
	ROLE_QUIRE_EDITOR, 	// Редактор вопросов
	ROLE_USER,			// Пользователь
	ROLE_VIEWER, 		// Просмотр
}
