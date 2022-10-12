package br.com.elizatest.rocket.domain.client.application.queries;

import java.time.LocalDate;

import br.com.elizatest.rocket.shared.query.ApplicationQuery;

public class GetClientById implements ApplicationQuery<GetClientById.ClientResult> {
    public final Integer id;
          
    public GetClientById(Integer id) {
        this.id = id;
        
    }
    public static class ClientResult {
        public final String name;
        public final String cpf;
        public final String email;
        public final String phone;
        public final String address;
        public final LocalDate birth;
        
        public ClientResult(String name, String cpf, String email, String phone, String address, LocalDate localDate) {
            this.name = name;
            this.cpf = cpf;
            this.email = email;
            this.phone = phone;
            this.address = address;
            this.birth = localDate;
        }
    }
    
}
