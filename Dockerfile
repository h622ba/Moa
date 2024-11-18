#
# Build stage
#
FROM gradle:jdk23-jammy AS build
COPY --chown=gradle:gradle ./ /home/gradle/src/
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

#
# Package stage
#
#FROM eclipse-temurin:23-jdk-jammy
#COPY --from=build /home/gradle/src/build/libs/docker-0.0.1-SNAPSHOT.jar moa.jar
#ENTRYPOINT ["java","-jar","/moa.jar"] 

FROM openjdk:23
WORKDIR /app
COPY --from=build /home/gradle/src/build/libs/docker-0.0.1-SNAPSHOT.jar moa.jar
ENTRYPOINT ["java","-jar","/moa.jar"]
