FROM eclipse-temurin:17-jre-alpine as builder
WORKDIR /opt/application
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM eclipse-temurin:17-jre-alpine
WORKDIR /opt/application
COPY --from=builder /opt/application/dependencies/ ./
COPY --from=builder /opt/application/snapshot-dependencies/ ./
COPY --from=builder /opt/application/spring-boot-loader/ ./
COPY --from=builder /opt/application/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]