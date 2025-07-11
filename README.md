
# Kafka Lab Practice

## Опис

Навчальний проєкт для ознайомлення з принципами подійно-орієнтованої архітектури (Event-Driven Architecture) з використанням Apache Kafka у Docker-середовищі.

Проєкт складається з:
- конфігурації для запуску Kafka та Zookeeper за допомогою Docker Compose;
- Spring Boot продюсера (user-producer), що надсилає події про створення користувача;
- Spring Boot консьюмера (user-consumer), що приймає події та виводить повідомлення у консоль.

## Вимоги до середовища

- Docker Desktop або Docker Engine
- Java JDK 17+
- Maven
- IntelliJ IDEA або інше IDE для роботи з Java

## Інструкція з запуску

### 1. Запуск Kafka та Zookeeper

```bash
docker compose up -d
```

Перевірити стан:

```bash
docker compose ps
docker compose logs --tail 20 kafka
```

### 2. Створення Kafka-топіка

```bash
docker compose exec kafka kafka-topics --create --topic user.created --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1
```

Пояснення параметрів:
- `--topic user.created` — назва топіка.
- `--bootstrap-server localhost:9092` — адреса брокера.
- `--partitions 1` — кількість партицій.
- `--replication-factor 1` — кількість реплік.

### 3. Запуск продюсера (user-producer)

Перейти в папку:

```bash
cd user-producer
./mvnw spring-boot:run
```

### 4. Відправка HTTP-запиту до продюсера

```bash
curl.exe -X POST http://localhost:8080/users ^
  -H "Content-Type: application/json" ^
  -d "{\"email\":\"ivan@example.com\", \"name\":\"Іван\"}"
```

### 5. Перевірка повідомлень у Kafka

```bash
docker compose exec kafka kafka-console-consumer --bootstrap-server localhost:9092 --topic user.created --from-beginning
```

### 6. Запуск консьюмера (user-consumer)

Перейти в папку:

```bash
cd user-consumer
./mvnw spring-boot:run
```

У консолі має виводитись повідомлення на кшталт:

```
Вітаємо, Іван (ivan@example.com)!
```

