package pk.home.inquirer.domain;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Index;

import pk.home.inquirer.domain.security.UserAccount;

/**
 * Entity class: Rating Rating - рейтинг
 * 
 */
@Entity
@Table(schema = "public", name = "Rating", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "useraccount_id", "inquirer_id"}) })
@NamedQueries({
		@NamedQuery(name = "Rating.findAll", query = "select a from Rating a order by a.id"),
		@NamedQuery(name = "Rating.findByPrimaryKey", query = "select a from Rating a where a.id = ?1") })
public class Rating implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@Index(name = "rating_idx1")
	private Inquirer inquirer;

	@ManyToOne
	@Index(name = "rating_idx1")
	private UserAccount userAccount;

	@NotNull
	@Column(nullable = false)
	private int val;

	private String description;

	public Rating() {
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
	
	public Inquirer getInquirer() {
		return inquirer;
	}

	public void setInquirer(Inquirer inquirer) {
		this.inquirer = inquirer;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
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
		if (!(object instanceof Rating)) {
			return false;
		}
		Rating other = (Rating) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "pk.home.inquirer.domain.Rating[ id=" + id + " ]";
	}

}
