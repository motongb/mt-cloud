#!/bin/sh
./mvnw clean package -DskipTests && docker-compose up -d