/**
 * @author: Bianca Koinegg
 * Version 1.0
 * 14.04.2019
 */
package at.fhv.persistencejava.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements IEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer _id;
	
	@Column(name="username")
	private String _username;
	
	@Column(name="password")
	private String _password;
	
	@ManyToOne(optional = false)
	@JoinColumn(name ="roleid")
	private Role role;

	public Integer getId() {
		return _id;
	}

	public String getUsername() {
		return _username;
	}

	public void setUsername(String username) {
		_username = username;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		_password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setId(Integer id) {
		_id = id;
	}
}
