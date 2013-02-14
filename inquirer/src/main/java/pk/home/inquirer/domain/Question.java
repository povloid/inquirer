package pk.home.inquirer.domain;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Entity class: Question Question - вопрос
 * 
 */
@Entity
@Table(schema = "public", name = "Question")
@NamedQueries({
		@NamedQuery(name = "Question.findAll", query = "select a from Question a order by a.id"),
		@NamedQuery(name = "Question.findByPrimaryKey", query = "select a from Question a where a.id = ?1") })
public class Question implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(unique = true, nullable = false)
	private String keyName;

	@NotNull
	@Column(nullable = false)
	private String qText;

	private String description;

	@OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
	@OrderColumn(name = "orId")
	private List<Answer> answers;

	@ManyToOne
	private Inquirer inquirer;
	
	
	public Question() {
		super();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKeyName() {
		return this.keyName;
	}

	public void setKeyName(String keyName) {
		System.out.println(keyName);
		this.keyName = keyName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getqText() {
		return qText;
	}

	public void setqText(String qText) {
		this.qText = qText;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Inquirer getInquirer() {
		return inquirer;
	}

	public void setInquirer(Inquirer inquirer) {
		this.inquirer = inquirer;
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
		if (!(object instanceof Question)) {
			return false;
		}
		Question other = (Question) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "pk.home.inquirer.domain.Question[ id=" + id + " ]";
	}

}
