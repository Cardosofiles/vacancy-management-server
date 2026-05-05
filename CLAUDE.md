# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Commands

```bash
# Run locally (requires .env and a running Postgres)
./mvnw spring-boot:run

# Build JAR (skip tests)
./mvnw clean package -DskipTests

# Run all tests
./mvnw test

# Run a single test class
./mvnw test -Dtest=VacancyManagementServerApplicationTests

# Dev environment (uses Dockerfile.dev + docker-compose.override.yml)
docker compose up -d

# Production build
docker compose -f docker-compose.yml up --build
```

## Architecture

Spring Boot 3.5.0 / Java 17 REST API. Features are organized into **modules** under `src/main/java/.../modules/`, each following the same layered structure:

```
modules/
  candidate/
    controllers/   # @RestController
    entities/      # @Entity (JPA)
    repositories/  # Spring Data JPA interfaces
    services/      # Business logic — single public execute() method
  company/
    controllers/
    entities/      # CompanyEntity, JobEntity
    repositories/
    services/      # CreateComponyService (typo in class name), CreateJobService
exceptions/        # Global @ControllerAdvice + ErrorMessageDTO + custom exceptions
```

Services expose a single `execute()` method. Note: `CreateCandidateService` has a typo — the method is named `excecute()`.

Global validation errors are handled by `ExceptionHandlerController` (`@ControllerAdvice`), which returns a `List<ErrorMessageDTO>` with field-level messages on `400 Bad_Request`. Duplicate-user detection throws `UserFoundException`.

All datasource config comes from env vars (`SPRING_DATASOURCE_URL`, `SPRING_DATASOURCE_USERNAME`, `SPRING_DATASOURCE_PASSWORD`). Copy `.env.example` → `.env` before first run.

`spring.jpa.hibernate.ddl-auto=update` — the schema is managed automatically by Hibernate, no migration tool is in use.

## Running services (docker-compose)

| Service     | Port | Purpose                        |
|-------------|------|--------------------------------|
| app         | 8080 | Spring Boot API                |
| db          | 5432 | PostgreSQL 15                  |
| swagger-ui  | 9000 | Standalone Swagger UI (yaml)   |
| pgadmin     | 5050 | PgAdmin4 (credentials in .env) |

Springdoc OpenAPI also serves docs at `http://localhost:8080/swagger-ui.html`.
