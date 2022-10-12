package br.com.elizatest.rocket.domain.order.infrasctructure;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.elizatest.rocket.domain.client.core.Client;

@Entity 
@Table(name = "clients") 
public class ClientOrderModel {
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

	public ClientOrderModel(Integer id, String name, String cpf, String email, String phone, String address,
			LocalDate birth, Boolean deleted) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.birth = birth;
		this.deleted = deleted;

	}

	// ?
	public Client toClient() {
		return new Client(id, name, cpf, email, phone, address, birth);
	}

	// ?
	public ClientOrderModel() {

	}

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

	public Boolean getDeleted() {
		return deleted;
	}
	
    public void setDeleted(Boolean deleted) {		
		this.deleted = deleted;
	}
		
}
