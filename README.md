# 📊 Event-Driven Monitoring System (Kafka + Spring Boot + Grafana)

## 📌 Описание проекта

Этот проект представляет собой учебную распределённую систему для обработки событий и мониторинга нагрузки.

Архитектура включает:

* генерацию нагрузки через JMeter
* потоковую обработку через Kafka
* backend на Spring Boot
* хранение данных в PostgreSQL
* мониторинг метрик через Prometheus
* визуализацию в Grafana
* дополнительные метрики через Kafka Exporter и Postgres Exporter
* нагрузочную аналитику через InfluxDB

---

## 🧱 Архитектура системы

```
JMeter
   ↓
InfluxDB
   ↓
Grafana

JMeter → Kafka → Spring Boot → PostgreSQL
                     ↓
                Prometheus
                     ↓
                  Grafana
```

---

## ⚙️ Используемые технологии

* Java 21
* Spring Boot
* Apache Kafka
* PostgreSQL
* Docker / Docker Compose
* Prometheus
* Grafana
* InfluxDB
* JMeter

---

## 📦 Сервисы

| Сервис      | Назначение             |
| ----------- | ---------------------- |
| Kafka       | брокер сообщений       |
| Spring Boot | обработка событий      |
| PostgreSQL  | хранение данных        |
| Prometheus  | сбор метрик            |
| Grafana     | визуализация           |
| InfluxDB    | хранение JMeter метрик |
| Zookeeper   | управление Kafka       |

---

## 🚀 Запуск проекта

### 1. Клонировать репозиторий

```bash
git clone https://github.com/your-name/your-repo.git
cd your-repo
```

---

### 2. Запустить систему

```bash
docker compose up -d --build
```

---

### 3. Доступ к сервисам

| Сервис     | URL                   | login | password|
| ---------- | --------------------- |-------|---------|
| Grafana    | http://localhost:3000 |admin  |admin    |
| Prometheus | http://localhost:9090 |       |         |
| Kafka      | localhost:9092        |       |         |
| PostgreSQL | localhost:5432        |       |         |
| InfluxDB   | http://localhost:8086 |       |         |

---

## 📊 Дашборды Grafana

* JVM Metrics
* Kafka Lag
* PostgreSQL Connections
* JMeter Load Test
* System Overview Dashboard

---

## 📈 Нагрузочное тестирование

Проект включает сценарии JMeter:

* генерация заказов
* отправка событий в Kafka
* проверка обработки Spring Boot

Метрики сохраняются в InfluxDB и визуализируются в Grafana.

---

## 🧠 Что демонстрирует проект

* Event-driven архитектуру
* Работа с Kafka Producer/Consumer
* Интеграцию Spring Boot и PostgreSQL
* Мониторинг через Prometheus
* Визуализацию через Grafana
* Контейнеризацию через Docker Compose
* Нагрузочное тестирование через JMeter

---

## 📂 Структура проекта

```
.
├ docker-compose.yml
├ Test Plan.jmx
├ prometheus.yml
├ init.sql
├ demo
├ grafana
└ README.md
```

---

