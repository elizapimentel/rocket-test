package br.com.elizatest.rocket.client.application.queries;

import br.com.elizatest.rocket.shared.query.ApplicationQuery;

public class GetAllClients implements ApplicationQuery<GetAllClients> {
    public final String name;
    public final String cpf;
    public final String email;
    public final String phone;
    public final String address;
    public final String birth;
    public final Boolean active;

    public GetAllClients(String name, String cpf, String email, String phone, String address, String birth, Boolean active) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.birth = birth;
        this.active = active;
    }
    
}
