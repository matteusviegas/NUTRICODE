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

---

## 🔄 Endpoints Principais

---

## 🧪 Exemplos JSON para Testes

---

## 🔗 Links

---

## 🧪 Exemplos JSON para Testes

---

## 👥 Integrantes

| RM       | Nome                       |
| -------- | -------------------------- |
| RM560914 | Lucas Almeida de Siqueira  |
| RM561090 | Matteus Viegas dos Santos  |
| RM561089 | Sulamita Viegas dos Santos |

