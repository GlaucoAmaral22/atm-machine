# ATM Machine

## Introdução

API REST para gerenciamento de usuários em um sistema de caixa eletrônico (ATM). O projeto foi desenvolvido com **Java 21** e **Quarkus 3.30.7**, aplicando os princípios de **Arquitetura Hexagonal (Ports & Adapters)** combinados com **CQRS (Command Query Responsibility Segregation)** para uma separação clara entre operações de escrita e leitura.

### Tecnologias

| Tecnologia | Versão |
|---|---|
| Java | 21 |
| Quarkus | 3.30.7 |
| Quarkus REST (RESTEasy Reactive) | — |
| Quarkus REST Jackson | — |
| Hibernate Validator | — |
| Gradle | — |

---

## Arquitetura

O projeto combina **Arquitetura Hexagonal** com **CQRS**, organizando o código nos seguintes pacotes raiz:

```
src/main/java/
├── application/          # Núcleo da aplicação (domínio + portas)
│   └── user/
│       ├── commands/     # Objetos de comando (escrita)
│       ├── domain/
│       │   ├── exceptions/   # Exceções de domínio
│       │   └── models/       # Agregado e Value Objects
│       ├── handlers/     # Command Handlers (casos de uso)
│       └── ports/
│           ├── inbound/  # Interfaces de entrada (contratos dos handlers)
│           └── outbound/ # Interfaces de saída (ex: repositório)
│
├── config/               # Configurações e wiring de dependências (CDI)
│
├── driven/               # Adaptadores de saída (infraestrutura)
│   └── user/
│       └── datasource/   # Implementação do repositório
│
├── driver/               # Adaptadores de entrada (HTTP)
│   └── user/
│       └── http/
│           ├── register/ # Endpoint POST /user
│           ├── update/   # Endpoint PUT /user/{id}
│           ├── validators/
│           └── exception/
│
└── query/                # Camada de consulta (CQRS - lado de leitura)
    └── user/
        └── find/         # Query Handler + Endpoint GET /user/{id}
```

### Princípios aplicados

- **Hexagonal Architecture**: O domínio (`application`) é totalmente isolado de frameworks e infraestrutura. A comunicação ocorre exclusivamente por meio de interfaces (`ports`).
- **CQRS**: Comandos de escrita (`RegisterUser`, `UpdateUser`) transitam pela camada `application` com seus respectivos handlers. Consultas (`FindUser`) são tratadas pela camada `query`, que é uma camada fina de leitura desacoplada do fluxo de domínio.
- **Value Objects**: `Cpf`, `Name` e `BirthDate` encapsulam as regras de validação de domínio diretamente em seus construtores, garantindo que objetos inválidos nunca sejam instanciados.

### Validações de domínio

| Value Object | Regras |
|---|---|
| `Cpf` | Não nulo/vazio · exatamente 11 dígitos (remove `.` e `-`) · não pode ter todos os dígitos iguais |
| `Name` | Não nulo/vazio · entre 2 e 100 caracteres · somente letras, espaços e `.'-` |
| `BirthDate` | Formato `yyyy-MM-dd` · não pode ser data futura · usuário deve ter no mínimo 18 anos · data não pode ser mais antiga que 150 anos |

---

## Endpoints

### Usuário

#### `POST /user` — Cadastrar usuário

Cria um novo usuário no sistema.

**Request Body**
```json
{
  "cpf": "12345678901",
  "name": "João da Silva",
  "birthDate": "1990-05-20"
}
```

**Response `201 Created`**
```json
{
  "id": "550e8400-e29b-41d4-a716-446655440000",
  "cpf": "12345678901",
  "name": "João da Silva",
  "birthDate": "1990-05-20"
}
```

---

#### `PUT /user/{id}` — Atualizar usuário

Atualiza o nome e/ou data de nascimento de um usuário existente.

**Path Parameter**

| Parâmetro | Tipo | Descrição |
|---|---|---|
| `id` | `UUID` | Identificador único do usuário |

**Request Body**
```json
{
  "name": "João Silva Atualizado",
  "birthDate": "1990-05-20"
}
```

**Response `204 No Content`**

---

#### `GET /user/{id}` — Buscar usuário

Retorna os dados de um usuário pelo seu identificador. Esta operação é tratada pela camada de **query (CQRS)**.

**Path Parameter**

| Parâmetro | Tipo | Descrição |
|---|---|---|
| `id` | `UUID` | Identificador único do usuário |

**Response `200 OK`**
```json
{
  "id": "550e8400-e29b-41d4-a716-446655440000",
  "cpf": "12345678901",
  "name": "João da Silva",
  "birthDate": "1990-05-20"
}
```

---

## Executando o projeto

### Modo desenvolvimento (live reload)

```bash
./gradlew quarkusDev
```

### Build e execução

```bash
./gradlew build
java -jar build/quarkus-app/quarkus-run.jar
```

A aplicação estará disponível em `http://localhost:8080`.

---