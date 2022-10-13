package br.com.elizatest.rocket.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

/* @SQLDelete(sql = "UPDATE clients SET deleted = true WHERE id=?") // This tells Hibernate to update the deleted column as true
@FilterDef(name = "deletedClientFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean")) // This tells Hibernate to create a filter to filter the deleted column
@Filter(name = "deletedClientFilter", condition = "deleted = :isDeleted") // This tells Hibernate to filter the deleted column */
@Entity 
@Table(name = "clients") 
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false, length = 100)
	private String name;
	@Column(length = 14, nullable = false)
	private String cpf;
	@Column(length = 70, nullable = false, unique = true)
	private String email;
	@Column(length = 15, nullable = false)
	private String phone;
	@Column(name = "address", length = 150, nullable = false)
	private String address;
	@Column(name = "birth", nullable = false)
	private LocalDate birth;
	@Column(name = "deleted")
	private Boolean deleted = Boolean.FALSE;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getBirth() {
		return birth;
	}

	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

}
