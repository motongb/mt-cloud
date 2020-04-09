#!/bin/sh
./mvnw clean package -DskipTests && pm2 restart pm2.config.js