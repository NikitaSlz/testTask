# Тестовое задание

## Системные требования

1. Установленная Java 17

## Параметры входных данных

1. Строка должна содержать только символы алфавита
2. Символы могут быть разделены пробелами
3. Длина строки меньше 10 символов
4. Строка не должна быть пустой или null
5. Пример входных данных: **aaaaabcccc**
6. Пример исходящих данных: **“a”: 5, “c”: 4, “b”: 1**

## Как запустить:

1. Запустить команду `mvn package`
2. Запустить `java -jar target/testTask-0.0.1-SNAPSHOT.jar`

## API

```
POST /message

Body: "aaaaabcccc"

Result example: “a”: 5, “c”: 4, “b”: 1
```

CURL:

```
curl --location --request POST 'localhost:8080/message' \
--header 'Content-Type: application/json' \
--data-raw 'aaaaabcccc'
```