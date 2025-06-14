# 🚀 Infraestrutura de qualidade também é código!

Hoje compartilho com vocês uma parte essencial do meu projeto Vacancy Management Server: a estrutura robusta que preparei para desenvolvimento e deploy com Docker + Spring Boot + Maven.

## 🛠️ O que você vai encontrar no repositório:

- `Dockerfile`: imagem de produção enxuta para rodar a aplicação com performance e segurança.
- `Dockerfile.dev`: ambiente voltado para desenvolvimento, com hot reload e build incremental.
- `docker-compose.yml`: orquestração dos containers com banco de dados e rede isolada.
- `docker-compose.override.yml`: configurações customizadas para facilitar o desenvolvimento local.
- `pom.xml`: dependências e configurações do Maven bem organizadas para build e testes automáticos.

## 💡 Essa estrutura foi pensada para garantir:

- Facilidade de uso no ambiente local.
- Escalabilidade e portabilidade do sistema.
- Separação de preocupações entre produção e desenvolvimento.
- Adoção de boas práticas com perfis Spring e variáveis de ambiente.

## 🔗 Confira o projeto completo no GitHub:

👉 https://www.github.com/Cardosofiles/vacancy-management-server

### 📌 Observações:

Se você trabalha com Java + Spring Boot e quer melhorar sua estrutura de containers, fica o convite para dar uma olhada, clonar e adaptar no seu próprio projeto!
