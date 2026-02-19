package application.commands;

import application.domain.models.BirthDate;
import application.domain.models.Cpf;

public record UpdateUserCommand(Cpf cpf, String name, BirthDate birthDate) { }
