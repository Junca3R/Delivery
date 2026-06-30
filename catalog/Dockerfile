# Paso 1: Usar una imagen de Maven con Java 17 para compilar el proyecto
FROM maven:3.8.8-eclipse-temurin-17 AS build
WORKDIR /app

# Copiar el archivo pom.xml y descargar las dependencias (se guarda en caché para acelerar futuras compilaciones)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiar el código fuente y compilar el archivo JAR saltándose los tests temporales de BD
COPY src ./src
RUN mvn clean package -DskipTests

# Paso 2: Usar una imagen ligera de Java 17 para ejecutar la aplicación
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copiar el JAR generado desde la etapa de compilación
COPY --from=build /app/target/ms-catalog-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto en el que corre nuestro servicio
EXPOSE 8081

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]