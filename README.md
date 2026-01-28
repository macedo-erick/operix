# Operix ERP

A microservices-based Enterprise Resource Planning (ERP) system built with Spring Boot and Spring Cloud.

## Overview

Operix is a modular ERP solution designed using microservices architecture to provide scalability, maintainability, and flexibility. The system manages core business operations including inventory, people, and product management.

## Architecture

The project follows a microservices architecture with the following components:

- **Service Registry** - Service discovery using Spring Cloud Netflix Eureka (Port: 8761)
- **Config Server** - Centralized configuration management (Port: 8888)
- **Inventory Service** - Manages inventory and stock operations (Port: 8081)
- **People Service** - Handles employee and customer management (Port: 8082)
- **Product Service** - Manages product catalog and information (Port: 8083)

### Infrastructure

- **PostgreSQL 16** - Primary database (Port: 5432)
- **Apache Kafka 7.5.0** - Event-driven messaging and communication between services (Ports: 9092, 9093)
- **Zookeeper** - Kafka coordination (Port: 2181)

## Technology Stack

- **Java 21** (Eclipse Temurin)
- **Spring Boot 3.4.x**
- **Spring Cloud 2024.0.x**
- **Spring Cloud Gateway** - API Gateway
- **Spring Cloud Config** - Centralized configuration
- **Spring Cloud Netflix Eureka** - Service discovery
- **Gradle 9.2+** - Build automation
- **Docker & Docker Compose** - Containerization
- **PostgreSQL 16** - Relational database
- **Apache Kafka 7.5.0** - Message broker
- **Lombok** - Reduce boilerplate code
- **SpringDoc OpenAPI** - API documentation
- **Micrometer & Actuator** - Metrics and monitoring

## Prerequisites

- Java 21 or higher
- Docker and Docker Compose
- Gradle (or use included Gradle wrapper)

## Getting Started

### Running with Docker Compose (Production)

1. Clone the repository
2. Navigate to the project root directory
3. Start all services:

```bash
docker compose -f compose.yaml up -d
```

This will start all microservices along with PostgreSQL, Kafka, and Zookeeper.

### Running with Docker Compose (Development - Hot Reload)

For development with automatic code reloading:

```bash
docker compose -f compose-dev.yaml up -d
```

**Development features:**
- ✅ Spring DevTools enabled for hot reload
- ✅ Source code changes detected automatically
- ✅ ~5-10 seconds for changes to take effect
- ✅ No rebuild needed when editing `.java` files

**Monitor hot reload:**
```bash
docker logs -f <service-name>
```

See `HOT_RELOAD_GUIDE.md` for detailed information.

### API Endpoints

**Service Registry & Discovery:**
- Eureka Dashboard: http://localhost:8761

**Configuration:**
- Config Server: http://localhost:8888

**Microservices (via API Gateway):**
- API Gateway: http://localhost:8080

**Direct Service Access:**
- Inventory Service: http://localhost:8081
- People Service: http://localhost:8082
- Product Service: http://localhost:8083

**API Documentation:**
Each service exposes Swagger UI at:
- `http://localhost:<port>/swagger-ui.html`

### Health Checks

Each service exposes actuator endpoints for monitoring:

- `http://localhost:<port>/actuator/health`
- `http://localhost:<port>/actuator/health/liveness`
- `http://localhost:<port>/actuator/health/readiness`
- `http://localhost:<port>/actuator/prometheus`

## Configuration

### Database

The system uses **PostgreSQL 16** as the primary database. Each microservice can have its own schema:

- **Database**: operix
- **User**: operix_user
- **Port**: 5432

### Message Broker

**Apache Kafka** is used for asynchronous communication:
- **Bootstrap servers**: localhost:9092 (internal), localhost:9093 (external)
- **Zookeeper**: localhost:2181

## Development

### Building Individual Services

Navigate to any service directory and build using Gradle:

```bash
cd inventory-service
./gradlew build
```

### Running Services Locally (Without Docker)

To run a service directly on your machine:

```bash
cd <service-name>
./gradlew bootRun
```

**Note:** Make sure PostgreSQL and Kafka are running and accessible.

### Project Structure

```
operix/
├── api-gateway/         # API Gateway (Spring Cloud Gateway)
├── config-server/       # Configuration server (Spring Cloud Config)
├── service-registry/    # Eureka service registry
├── inventory-service/   # Inventory management microservice
├── people-service/      # People management microservice
├── product-service/     # Product management microservice
├── compose.yaml         # Production Docker Compose
├── compose-dev.yaml     # Development Docker Compose (hot reload)
└── HOT_RELOAD_GUIDE.md  # Development guide
```

## Purpose

Operix ERP aims to provide a modern, scalable solution for managing essential business operations. The microservices architecture allows:

- **Scalability** - Individual services can be scaled independently
- **Resilience** - Failure isolation and fault tolerance
- **Flexibility** - Easy to add new services or modify existing ones
- **Event-Driven** - Kafka enables asynchronous communication and event sourcing
- **Cloud-Ready** - Containerized and ready for cloud deployment

## Useful Commands

### Docker Compose

```bash
# Start all services (production)
docker compose -f compose.yaml up -d

# Start all services (development with hot reload)
docker compose -f compose-dev.yaml up -d

# Stop all services
docker compose -f compose-dev.yaml down

# View logs
docker compose -f compose-dev.yaml logs -f <service-name>

# Check service status
docker compose -f compose-dev.yaml ps

# Rebuild services
docker compose -f compose-dev.yaml build

# Restart a single service
docker compose -f compose-dev.yaml restart <service-name>
```

### Gradle

```bash
# Build all services
./gradlew build

# Run tests
./gradlew test

# Clean build
./gradlew clean build

# Run a specific service
cd <service-name>
./gradlew bootRun
```

### Monitoring

```bash
# Check service health
curl http://localhost:8081/actuator/health

# View metrics
curl http://localhost:8081/actuator/metrics

# View Eureka dashboard
open http://localhost:8761
```

## Troubleshooting

### Services not starting

1. Check logs: `docker compose -f compose-dev.yaml logs <service-name>`
2. Verify ports are available: `netstat -tulpn | grep <port>`
3. Ensure dependencies are healthy: `docker compose -f compose-dev.yaml ps`

### Hot reload not working

See `HOT_RELOAD_GUIDE.md` for detailed troubleshooting steps.

### Database connection issues

Verify PostgreSQL is running and accessible:
```bash
docker exec -it operix-postgres psql -U operix_user -d operix
```

## License

This project is proprietary software.
