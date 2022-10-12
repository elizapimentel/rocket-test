package br.com.elizatest.rocket.domain.client.application.commands;

import java.time.LocalDate;

import br.com.elizatest.rocket.shared.command.ApplicationCommand;

public class UpdateClientCommand implements ApplicationCommand<Void> {
    public final Integer id;
    public final String name;
    public final String cpf;
    public final String email;
    public final String phone;
    public final String address;
    public final LocalDate birth;

    public UpdateClientCommand(Integer id, String name, String cpf, String email, String phone, String address, LocalDate birth) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.birth = birth;
    }
}
    
