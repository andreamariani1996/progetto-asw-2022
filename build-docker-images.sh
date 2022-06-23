#!/bin/bash

# Script per la build delle immagini Docker

echo Building EDIPOGRAM 

docker-compose -f docker-compose.yml build