# Kafka Project – User Producer / Consumer Microservices

![CI/CD](https://github.com/LesieBarbie/kafka-lab/actions/workflows/deploy.yaml/badge.svg)

## Опис проєкту

Цей проєкт демонструє реалізацію **Event-Driven Architecture (EDA)** з використанням Apache Kafka. Складається з двох основних мікросервісів:

- **user-producer** – REST-сервіс, який приймає дані користувача та надсилає повідомлення в Kafka.
- **user-consumer** – сервіс, який слухає Kafka-топік `user.created` та обробляє отримані повідомлення.

Проєкт також містить повну інфраструктуру для запуску в **Docker**, **Kubernetes** (через Helm) і налаштований **CI/CD pipeline через GitHub Actions**.


---

## Запуск через Docker Compose

```bash
docker-compose up -d
```

Kafka UI: [http://localhost:8080](http://localhost:8080)

---

## Запуск мікросервісів вручну

```bash
cd user-producer
./mvnw spring-boot:run
```

```bash
cd user-consumer
./mvnw spring-boot:run
```

---

## Деплой у Kubernetes (Minikube або Docker Desktop)

```bash
kubectl config use-context docker-desktop
helm install user-apps ./helm-chart
kubectl get pods
kubectl get svc
```

---

## CI/CD з GitHub Actions

Файл `.github/workflows/deploy.yaml` запускає автоматичний деплой у Kubernetes при пуші.  
Використовується **self-hosted runner**.

```yaml
run: helm upgrade --install user-apps ./helm-chart
```

---

## API Endpoint (POST)

```http
POST /users
Content-Type: application/json

{
  "id": 1,
  "name": "Alice"
}
```

---

## Технології

- Java 17 + Spring Boot
- Apache Kafka
- Kafka UI / Schema Registry
- Docker + Docker Compose
- Kubernetes (Helm)
- GitHub Actions CI/CD

---
