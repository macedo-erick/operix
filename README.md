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

- **MySQL 8.0** - Primary database (Port: 3306)
- **Apache Kafka** - Event-driven messaging and communication between services (Ports: 9092, 9093)
- **Zookeeper** - Kafka coordination (Port: 2181)

## Technology Stack

- **Java 21**
- **Spring Boot 4.0.1**
- **Spring Cloud 2025.1.0**
- **Gradle** - Build automation
- **Docker & Docker Compose** - Containerization
- **MySQL** - Relational database
- **Apache Kafka** - Message broker
- **Lombok** - Reduce boilerplate code
- **Micrometer & Prometheus** - Metrics and monitoring

## Prerequisites

- Java 21 or higher
- Docker and Docker Compose
- Gradle (or use included Gradle wrapper)

## Getting Started

### Running with Docker Compose

1. Clone the repository
2. Navigate to the project root directory
3. Start all services:

```bash
docker-compose up -d
```

This will start all microservices along with MySQL, Kafka, and Zookeeper.

### Service Endpoints

- Service Registry: http://localhost:8761
- Config Server: http://localhost:8888
- Inventory Service: http://localhost:8081
- People Service: http://localhost:8082
- Product Service: http://localhost:8083

### Health Checks

Each service exposes actuator endpoints for monitoring:

- `http://localhost:<port>/actuator/health`
- `http://localhost:<port>/actuator/prometheus`

## Development

### Building Individual Services

Navigate to any service directory and build using Gradle:

```bash
cd inventory-service
./gradlew build
```

### Running Services Locally

Each service can be run independently with the appropriate environment variables set for database and Kafka connections.

## Project Structure

```
operix/
├── config-server/       # Configuration server
├── service-registry/    # Eureka service registry
├── inventory-service/   # Inventory management
├── people-service/      # People management
├── product-service/     # Product management
└── compose.yaml         # Docker Compose configuration
```

## Purpose

Operix ERP aims to provide a modern, scalable solution for managing essential business operations. The microservices architecture allows:

- **Scalability** - Individual services can be scaled independently
- **Resilience** - Failure isolation and fault tolerance
- **Flexibility** - Easy to add new services or modify existing ones
- **Event-Driven** - Kafka enables asynchronous communication and event sourcing
- **Cloud-Ready** - Containerized and ready for cloud deployment

## License

This project is proprietary software.
