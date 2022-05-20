#!/bin/sh

./gradlew clean assemble -Dmaven.test.skip=true

docker-compose -f docker-compose.yml up --build