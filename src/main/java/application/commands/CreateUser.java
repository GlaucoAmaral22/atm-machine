package application.commands;

public class CreateUser {
    public final String name;
    public final String document;
    public final String birthDate;

    public CreateUser(String name, String document, String birthDate) {
        this.name = name;
        this.document = document;
        this.birthDate = birthDate;
    }
}
