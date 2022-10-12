package br.com.elizatest.rocket.domain.client.application.commands;

import java.time.LocalDate;

import br.com.elizatest.rocket.shared.command.ApplicationCommand;

public class CreateClientCommand implements ApplicationCommand<Void> {
    public final String name;
    public final String cpf;
    public final String email;
    public final String phone;
    public final String address;
    public final LocalDate birth;

    public CreateClientCommand(String name, String cpf, String email, String phone, String address, LocalDate birth) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.birth = birth;
    }
}
