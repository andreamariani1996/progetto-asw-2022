#!/bin/bash

# Script per avviare l'applicazione Edipogram 

echo Running EDIPOGRAM 

docker-compose up -d --scale enigmi-seguiti=2 --scale enigmi=2 --scale connessioni=2