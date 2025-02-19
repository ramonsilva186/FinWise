# FinWise - Controle de Gastos Pessoais

## 📌 Sobre o Projeto

O **FinWise** é um sistema web para controle de gastos pessoais, permitindo o gerenciamento de despesas, receitas e categorias. O projeto é desenvolvido em **Java com Spring Boot** e futuramente terá autenticação via Google e um aplicativo mobile.

> 🔹 **Este é apenas o backend do projeto.**
> 🔹 **O sistema ainda está em desenvolvimento e futuramente será criado o front-end.**

## 🚀 Tecnologias Utilizadas

- **Back-end:** Java 17, Spring Boot, Spring Data JPA, Spring Web
- **Banco de Dados:** H2 Database (para desenvolvimento), futura integração com PostgreSQL
- **Autenticação:** JWT (futuramente OAuth com Google)
- **Documentação:** Swagger (Springdoc OpenAPI)

## ⚙️ Configuração do Projeto

### 1️⃣ Clonar o Repositório

```sh
git clone https://github.com/seu-usuario/finwise.git
cd finwise
```

### 2️⃣ Configurar o Banco de Dados H2

O H2 Database está configurado no arquivo `application.properties`. Acesse o console em: 🔗 `http://localhost:8080/h2-console`

**Credenciais:**

- JDBC URL: `jdbc:h2:mem:finwise`
- Usuário: `sa`
- Senha: (vazia)

### 3️⃣ Rodar o Projeto

No terminal, execute:

```sh
./mvnw spring-boot:run
```

Ou no IntelliJ, rode a classe `FinWiseApplication.java`.

### 4️⃣ Acessar o Swagger

Acesse a documentação no navegador: 🔗 `http://localhost:8080/swagger-ui.html`

## 📌 Endpoints Principais

### **Users** (`/users`)

- `POST /users` - Criar usuário
- `GET /users/{id}` - Buscar usuário por ID
- `PUT /users/{id}` - Atualizar usuário
- `DELETE /users/{id}` - Remover usuário

### **Expense** (`/expenses`)

- `POST /expenses` - Criar despesa
- `GET /expenses/{id}` - Buscar despesa por ID
- `PUT /expenses/{id}` - Atualizar despesa
- `DELETE /expenses/{id}` - Remover despesa

### **Income** (`/incomes`)

- `POST /incomes` - Criar entrada de dinheiro
- `GET /incomes/{id}` - Buscar entrada por ID
- `PUT /incomes/{id}` - Atualizar entrada
- `DELETE /incomes/{id}` - Remover entrada

### **ExpenseCategory** (`/expense-categories`)

- `POST /expense-categories` - Criar categoria de despesa
- `GET /expense-categories/{id}` - Buscar categoria por ID
- `PUT /expense-categories/{id}` - Atualizar categoria
- `DELETE /expense-categories/{id}` - Remover categoria

## 📌 Próximos Passos

- 📌 Implementar autenticação JWT
- 📌 Criar filtros de busca e relatórios
- 📌 Desenvolver o front-end com Angular
- 📌 Criar a versão mobile do aplicativo

---

🚀 **FinWise** - Controle suas finanças de forma eficiente!

