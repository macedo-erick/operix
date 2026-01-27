# -------- STAGE 1: BUILD --------
FROM gradle:8.14-jdk21 AS builder

WORKDIR /app

# Copia arquivos de configuração do Gradle
COPY build.gradle settings.gradle ./
COPY --chown=gradle:gradle gradle ./gradle
COPY --chown=gradle:gradle gradlew ./

# Download das dependências (camada separada para cache)
RUN gradle dependencies --no-daemon || true

# Copia o código fonte
COPY src ./src

# Build do jar com Spring Boot layered structure
RUN gradle clean bootJar -x test --no-daemon

# Extrai as camadas do JAR para otimizar cache do Docker
RUN java -Djarmode=layertools -jar build/libs/*.jar extract --destination extracted

# -------- STAGE 2: RUNTIME --------
FROM eclipse-temurin:21-jre-alpine

# Argumentos de build
ARG APP_PORT=8080
ARG APP_USER=appuser
ARG APP_UID=1000

# Instala curl para health checks
RUN apk add --no-cache curl

# Cria usuário não-root para segurança
RUN adduser -D -u ${APP_UID} ${APP_USER}

WORKDIR /app

# Copia as camadas extraídas do JAR (melhor cache entre deploys)
COPY --from=builder --chown=${APP_USER}:${APP_USER} /app/extracted/dependencies/ ./
COPY --from=builder --chown=${APP_USER}:${APP_USER} /app/extracted/spring-boot-loader/ ./
COPY --from=builder --chown=${APP_USER}:${APP_USER} /app/extracted/snapshot-dependencies/ ./
COPY --from=builder --chown=${APP_USER}:${APP_USER} /app/extracted/application/ ./

# Troca para usuário não-root
USER ${APP_USER}

# Expõe a porta da aplicação
EXPOSE ${APP_PORT}

# Health check
HEALTHCHECK --interval=30s --timeout=5s --start-period=5s --retries=3 \
    CMD curl -f http://localhost:${APP_PORT}/actuator/health || exit 1

# Inicia a aplicação
ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]
