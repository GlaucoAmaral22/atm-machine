package application.user.commands;

import application.user.domain.models.BirthDate;
import application.user.domain.models.Cpf;

public record RegisterUserCommand(Cpf cpf, String name, BirthDate birthDate) { }
