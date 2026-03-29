# reqsh

A lightweight CLI API client built with Java, Picocli, and Jackson.

## Features
- HTTP requests (GET, POST, PUT, DELETE)
- JSON handling

## Tech Stack
- Java
- Picocli
- Jackson
- Maven

## Usage

Get Method
```bash
java -jar example.jar get "https://api.example.com"
```

Post Method
```bash
java -jar example.jar post -d "data" "https://api.example.com"
```

Put Method
```bash
java -jar example.jar put -i 1 -d "data" "https://api.example.com"
```

Delete Method
```bash
java -jar example.jar delete -i 1 "https://api.example.com"
```
