######################################################
# Dockerfile per l'applicazione engmi / connessioni 
######################################################

FROM openjdk:17-jdk 

# RUN apt-get update && apt-get install -y curl

ADD build/libs/connessioni.jar connessioni.jar

ENTRYPOINT ["java", "-Xmx128m", "-Xms128m", "-jar", "connessioni.jar"]

# HEALTHCHECK --start-period=30s --interval=10s CMD curl -f http://localhost:8080/actuator/health || exit 1
