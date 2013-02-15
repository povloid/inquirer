package pk.home.inquirer.domain;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.List;
import java.util.Map;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Entity class: Inquirer inquirer - опрос
 * 
 */
@Entity
@Table(schema = "public", name = "Inquirer")
@NamedQueries({
		@NamedQuery(name = "Inquirer.findAll", query = "select a from Inquirer a order by a.id"),
		@NamedQuery(name = "Inquirer.findByPrimaryKey", query = "select a from Inquirer a where a.id = ?1")})
public class Inquirer implements Serializable {

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

	@OneToMany(mappedBy = "inquirer", fetch = FetchType.LAZY)
	private List<Question> questions;

	private String description;
	
	@Transient
	private Object addInfo;

	public Inquirer() {
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

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	public Object getAddInfo() {
		return addInfo;
	}

	public void setAddInfo(Object addInfo) {
		this.addInfo = addInfo;
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
		if (!(object instanceof Inquirer)) {
			return false;
		}
		Inquirer other = (Inquirer) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "pk.home.inquirer.domain.Inquirer[ id=" + id + " ]";
	}

}
