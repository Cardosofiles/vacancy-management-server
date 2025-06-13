# Etapa 1: Build com cache de dependências
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

# Copia apenas arquivos relacionados a dependências para usar cache
COPY pom.xml ./
COPY .mvn/ .mvn/
COPY mvnw ./

# Baixa dependências para cache
RUN ./mvnw dependency:go-offline -B

# Copia o restante do projeto
COPY src ./src

# Gera o JAR otimizado (usa spring-boot-maven-plugin com reempacotamento)
RUN ./mvnw clean package -DskipTests -B

# Etapa 2: Imagem final leve e segura
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copia somente o JAR final da etapa de build
COPY --from=builder /app/target/*.jar app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Permite passar variáveis como SPRING_PROFILES_ACTIVE em tempo de execução
ENTRYPOINT ["java", "-jar", "app.jar"]
