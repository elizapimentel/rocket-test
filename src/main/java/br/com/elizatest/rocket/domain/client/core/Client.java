package br.com.elizatest.rocket.domain.client.core;

import java.time.LocalDate;
import java.util.Objects;


public class Client {

	private Integer id;
	private String name;	
	private String cpf;
	private String email;
	private String phone;
	private String address;	
	private LocalDate birth;
    private Boolean deleted;

    
    public Client(Integer id, String name, String cpf, String email, String phone, String address, LocalDate birth) {
        this.id = id;
        this.editName(name);
        this.cpf = Objects.requireNonNull(cpf);
        if (cpf.isEmpty()) throw new IllegalArgumentException ("O cpf não pode ser vazio");
        if (cpf.length() != 11) throw new IllegalArgumentException("CPF inválido");
        this.editEmail(email);
        this.editPhone(phone);
        this.editAddress(address);
        this.editBirth(birth);
        this.deleted = false; //?
    
        
    }
    
    public void update(String name, String cpf, String email, String phone, String address, LocalDate birth) {
        this.editName(name);
        this.cpf = Objects.requireNonNull(cpf);
        if (cpf.isEmpty()) throw new IllegalArgumentException ("O cpf não pode ser vazio");
        if (cpf.length() != 11) throw new IllegalArgumentException("CPF inválido");
        this.editEmail(email);
        this.editPhone(phone);
        this.editAddress(address);
        this.editBirth(birth);
    }
    
    //?
    public void delete() {
        this.deleted = false;
    }

    /* public Client get(String name, String cpf, String email, String phone, String address, LocalDate birth, Boolean deleted) {
        if (!this.deleted) throw new IllegalArgumentException("Cliente não encontrado");
        return new Client(id, name, cpf, email, phone, address, birth);
        
    } */
    
    public void editName(String name) {
        if (name.isEmpty()) throw new IllegalArgumentException ("O nome não pode ser vazio");
        this.name = Objects.requireNonNull(name);
    }
    public void editPhone (String phone) {        
        if (phone.isEmpty()) throw new IllegalArgumentException ("O telefone não pode ser vazio");
        this.phone = Objects.requireNonNull(phone);
    }
    
    public void editEmail (String email) {
        if (email.isEmpty()) throw new IllegalArgumentException ("O email não pode ser vazio");
        if (! email.contains("@")) throw new IllegalArgumentException ("email inválido");
        this.email = Objects.requireNonNull(email);
        
    }
    
    public void editAddress (String address) {
        if (address.isEmpty()) throw new IllegalArgumentException ("O endereço não pode ser vazio");
        this.address = Objects.requireNonNull(address);
    }
    
    public void editBirth (LocalDate birth) {
        if (birth.isAfter(LocalDate.now())) throw new IllegalArgumentException("Data de nascimento não pode ser depois de hoje");
        this.birth = Objects.requireNonNull(birth);
    }
    
    
    public Integer getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public String getAddress() {
        return address;
    }
    
    public LocalDate getBirth() {
        return birth;
    }
    
    public Boolean getDeleted() {
        return deleted;
    }
    
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    
}
