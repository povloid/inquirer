package pk.home.inquirer.domain;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Entity class: Answer
 * Answer - ответ
 *
 */
@Entity
@Table(schema = "public", name = "Answer")
@NamedQueries({
	@NamedQuery(name = "Answer.findAll", query = "select a from Answer a order by a.id"),
	@NamedQuery(name = "Answer.findByPrimaryKey", query = "select a from Answer a where a.id = ?1")})
public class Answer implements Serializable {

	   
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
    @Column(unique=true, nullable = false)
	private String keyName;
	
	
	private String description;
	

	public Answer() {
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
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// not set
		if (!(object instanceof Answer)) {
			return false;
		}
		Answer other = (Answer) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "pk.home.inquirer.domain.Answer[ id=" + id + " ]";
	}
   
}
