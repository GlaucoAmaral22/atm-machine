package driver.bankaccount.http.create;

import application.bankaccount.commands.CreateBankAccountCommand;

//TODO CRIAR ANOTACAO PARA AMBOS OS PARAMETROS
public record Request(String userId, String accountType) {
    public CreateBankAccountCommand toCommand() {
        return new CreateBankAccountCommand(this.userId(), this.accountType());
    }
}
