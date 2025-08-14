# Vacancy Management Server

Vacancy Management Server é uma aplicação backend desenvolvida em Java com Spring Boot, projetada para gerenciar vagas (vacancies) de forma eficiente, escalável e segura. O projeto utiliza Docker para facilitar o desenvolvimento, testes e deploy, além de integrar um banco de dados PostgreSQL e gerenciamento de dependências via Maven.

## ✨ Principais Tecnologias

- **Java 17+**
- **Spring Boot**
- **Maven**
- **PostgreSQL**
- **Docker & Docker Compose**

## 📦 Estrutura do Projeto

- `Dockerfile`: Cria uma imagem enxuta para produção.
- `Dockerfile.dev`: Ambiente de desenvolvimento com hot reload.
- `docker-compose.yml`: Orquestração dos containers (aplicação + banco de dados).
- `docker-compose.override.yml`: Customizações para desenvolvimento local.
- `pom.xml`: Gerenciamento de dependências e plugins Maven.
- `src/`: Código-fonte da aplicação.

## 🚀 Como Executar Localmente

### Pré-requisitos

- [Docker](https://www.docker.com/get-started)
- [Docker Compose](https://docs.docker.com/compose/)
- [Git](https://git-scm.com/)

### 1. Clone o repositório

```bash
git clone https://github.com/Cardosofiles/vacancy-management-server.git
cd vacancy-management-server
```

### 2. Configure variáveis de ambiente (opcional)

Você pode criar um arquivo `.env` para customizar variáveis como usuário e senha do banco.

### 3. Suba os containers

Para ambiente de desenvolvimento (hot reload):

```bash
docker-compose -f docker-compose.yml -f docker-compose.override.yml up --build
```

Para ambiente de produção:

```bash
docker-compose up --build
```

A aplicação estará disponível em `http://localhost:8080`.

### 4. Rodando testes

```bash
docker-compose exec app mvn test
```

## 🗄️ Banco de Dados

O serviço PostgreSQL é iniciado automaticamente via Docker Compose. As credenciais padrão podem ser alteradas via variáveis de ambiente.

## 🛠️ Principais Comandos Maven

- `mvn clean install` – Compila e empacota a aplicação.
- `mvn test` – Executa os testes automatizados.

## 🧩 Estrutura de Perfis

O projeto utiliza perfis Spring (`dev`, `prod`) para separar configurações de desenvolvimento e produção.

## 📚 Documentação da API

A documentação dos endpoints pode ser acessada (se habilitada) via `/swagger-ui.html` após subir a aplicação.

## 📝 Observações

- Sinta-se à vontade para clonar, adaptar e contribuir!
- Recomenda-se o uso de variáveis de ambiente para dados sensíveis.

## 🔗 Repositório

[https://github.com/Cardosofiles/vacancy-management-server](https://github.com/Cardosofiles/vacancy-management-server)

---

<div align="center">
  <code><img width="50" src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/git.png" alt="Git" title="Git"/></code>
  <code><img width="50" src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/java.png" alt="Java" title="Java"/></code>
  <code><img width="50" src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/spring_boot.png" alt="Spring Boot" title="Spring Boot"/></code>
  <code><img width="50" src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/maven.png" alt="Maven" title="Maven"/></code>
  <code><img width="50" src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/postgresql.png" alt="PostgreSQL" title="PostgreSQL"/></code>
  <code><img width="50" src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/docker.png" alt="Docker" title="Docker"/></code>
</div>
