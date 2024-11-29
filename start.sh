#!/bin/bash
echo "Start Docker Application"

DOCKER_COMOSE_FILE="docker-compose.yml"

echo "Using file: $DOCKER_COMOSE_FILE"

if [ ! -f "$DOCKER_COMOSE_FILE" ]; then
    echo "Error: File $DOCKER_COMOSE_FILE not found"
    exit 1
fi

docker-compose -f "$DOCKER_COMOSE_FILE" up -d

echo "Start Backend Application"
