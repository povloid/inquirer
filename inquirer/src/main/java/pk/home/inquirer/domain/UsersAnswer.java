package pk.home.inquirer.domain;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Index;

import pk.home.inquirer.domain.security.UserAccount;

/**
 * Entity class: UsersAnswer Users Answer - ответ пользователя
 * 
 */
@Entity
@Table(schema = "public", name = "UsersAnswer" , uniqueConstraints = {
		@UniqueConstraint(columnNames = { "useraccount_id", "inquirer_id", "question_id" }) })
@NamedQueries({
		@NamedQuery(name = "UsersAnswer.findAll", query = "select a from UsersAnswer a order by a.id"),
		@NamedQuery(name = "UsersAnswer.findByPrimaryKey", query = "select a from UsersAnswer a where a.id = ?1")})
public class UsersAnswer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@ManyToOne
	@Index(name = "users_answer_idx1")
	private UserAccount userAccount;

	@NotNull
	@ManyToOne
	@Index(name = "users_answer_idx1")
	private Inquirer inquirer;

	@NotNull
	@ManyToOne
	@Index(name = "users_answer_idx1")
	private Question question;

	@NotNull
	@ManyToOne
	private Answer answer;

	private String description;

	public UsersAnswer() {
		super();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public Inquirer getInquirer() {
		return inquirer;
	}

	public void setInquirer(Inquirer inquirer) {
		this.inquirer = inquirer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// not set
		if (!(object instanceof UsersAnswer)) {
			return false;
		}
		UsersAnswer other = (UsersAnswer) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "pk.home.inquirer.domain.UsersAnswer[ id=" + id + " ]";
	}

}
