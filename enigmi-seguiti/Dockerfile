######################################################
# Dockerfile per l'applicazione enigmi / enigmi-seguiti 
######################################################

FROM openjdk:17-jdk 

# RUN apt-get update && apt-get install -y curl

ADD build/libs/enigmi-seguiti.jar enigmi-seguiti.jar

ENTRYPOINT ["java", "-Xmx128m", "-Xms128m", "-jar", "enigmi-seguiti.jar"]

# HEALTHCHECK --start-period=30s --interval=10s CMD curl -f http://localhost:8080/actuator/health || exit 1
