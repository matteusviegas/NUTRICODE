# 🥗 NutriCode API - Sprint 4 DevOps

## 📌 Descrição da Solução

A **NutriCode API** é uma aplicação REST desenvolvida em **Java com Spring Boot**, criada para gerenciamento de informações nutricionais.

A solução permite realizar operações CRUD e utiliza banco de dados Oracle remoto, garantindo persistência dos dados e relacionamento entre tabelas.

Nesta Sprint, a aplicação foi integrada a uma esteira **CI/CD no Azure DevOps**, realizando build automatizado, geração do arquivo `.jar` e deploy automático no **Azure App Service**, serviço PaaS utilizado para hospedar a API em nuvem.

---

## 🚀 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Maven
- Oracle Database
- Azure DevOps
- Azure Pipelines
- Azure App Service
- GitHub
- Swagger
- Postman

---

## ☁️ Pipeline CI/CD

A pipeline foi configurada no **Azure DevOps** com duas etapas principais:

### 1. CI - Build

Nesta etapa, a pipeline:

- faz checkout do código;
- executa o build Maven;
- gera o arquivo `.jar`;
- publica o artefato da aplicação.

Comando utilizado:

```bash
mvn clean package -DskipTests
```

### 2. CD - Deploy

Nesta etapa, a pipeline:

- baixa o artefato gerado;
- localiza o arquivo .jar;
- envia o arquivo para o Azure App Service;
- disponibiliza a API em ambiente cloud

---

## 🧩 Fluxo da Solução

```text
GitHub / Azure Repos
        ↓
Azure DevOps Pipeline
        ↓
Build Maven
        ↓
Geração do arquivo .jar
        ↓
Deploy automático
        ↓
Azure App Service
        ↓
Oracle Database
```

---

## 🌐 URL da Aplicação

https://appservice-nutricode3-dacrb3byhuhcfkes.brazilsouth-01.azurewebsites.net

---

## 🗄️ Banco de Dados

A aplicação utiliza banco Oracle remoto acessado via JDBC.
O projeto contempla relacionamento entre tabelas, atendendo ao requisito de persistência de dados em banco relacional.
Exemplo de relacionamento utilizado:
Categoria 1:N Receita ou Usuário 1:N Histórico de Consumo

---

## ⚙️ Variáveis de Ambiente

No Azure App Service foram configuradas as seguintes variáveis:
DB_URL
DB_USER
DB_PASSWORD
JWT_SECRET
**Essas variáveis permitem configurar dados sensíveis no ambiente da aplicação, evitando exposição direta no código-fonte.**

---

## ▶️ Como Executar Localmente

### Pré-requisitos:
- Java 17
- Maven
- Acesso ao banco Oracle

### Executar o projeto

```text
mvn clean package -DskipTests
java -jar target/projectNutricode-0.0.1-SNAPSHOT.jar
```

### Domínio padrão para o uso da aplicação:

```text
appservice-nutricode3-dacrb3byhuhcfkes.brazilsouth-01.azurewebsites.net
```

---

## 🔄 Endpoints Principais

### Os endpoints podem ser acessados pelo Swagger ou Postman

```text
GET    /api/usuarios
POST   /api/usuarios
GET    /api/usuarios/{id}
PUT    /api/usuarios/{id}
DELETE /api/usuarios/{id}
```

### Outras rotas disponíveis:

```text
/api/receitas
/api/categorias-receita
/api/ingredientes
/api/historicos-consumo
/api/perfis
/api/preferencias-alimentares
/api/condicoes-medicas
```

---

## 🧪 Exemplos JSON para Testes

### Criar Usuário
```text
{
  "nome": "Usuario Teste",
  "email": "usuario.teste@email.com",
  "senha": "123456"
}
```
### Atualizar Usuário
```text
{
  "nome": "Usuario Atualizado",
  "email": "usuario.atualizado@email.com",
  "senha": "123456"
}
```

### Listar Usuário
```text
Método: GET
/api/usuarios
```

### Deletar Usuário
```text
Método: DELETE 
/api/usuarios/ID_AQUI
```

### Criar Receita
```text
{
  "nome": "Frango com Batata Doce",
  "descricao": "Receita rica em proteína para dieta fitness",
  "modoPreparo": "Grelhar o frango e cozinhar.",
  "tempoPreparo": 30,
  "valorCalorico": 450.00,
  "proteinaTotal": 38.50,
  "carboTotal": 42.00,
  "gorduraTotal": 8.20,
  "indiceGlicemico": "MEDIO",
  "categoriaId": 1
}
```
### Atualizar Receita
```text
{
  "nome": "Usuario Atualizado",
  "email": "usuario.atualizado@email.com",
  "senha": "123456"
}
```

### Listar Receita
```text
Método: GET
/api/receitas
```

### Deletar Receita
```text
Método: DELETE 
/api/receitas/ID_AQUI
```

---

## 👥 Integrantes

| RM       | Nome                       |
| -------- | -------------------------- |
| RM560914 | Lucas Almeida de Siqueira  |
| RM561090 | Matteus Viegas dos Santos  |
| RM561089 | Sulamita Viegas dos Santos |
