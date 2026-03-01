## Fluxo da Arquitetura (Hexagonal)

HTTP Controller
↓
CreateUser (Port IN)
↓
CreateUserHandler (Adapter IN + Application)
↓
UserRepository (Port OUT)
↓
SQL Adapter

- **HTTP Controller**: recebe a requisição HTTP
- **Port IN (CreateUser)**: define o contrato do caso de uso
- **Handler**: executa a regra de negócio. Ele pode tanto trabalhar como um orquestrador quanto chamar um ServiceDomain onde a regra é complexa, envolve multiplas entidades.
- **Port OUT (UserRepository)**: abstrai a persistência
- **SQL Adapter**: implementação concreta de acesso ao banco

