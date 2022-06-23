######################################################
# Dockerfile per l'applicazione enigmi / enigmi 
######################################################

FROM openjdk:17-jdk 

# RUN apt-get update && apt-get install -y curl

ADD build/libs/enigmi.jar enigmi.jar

ENTRYPOINT ["java", "-Xmx128m", "-Xms128m", "-jar", "enigmi.jar"]

# HEALTHCHECK --start-period=30s --interval=10s CMD curl -f http://localhost:8080/actuator/health || exit 1
