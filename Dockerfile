FROM maven:3.8.5-openjdk-17
COPY . /app
WORKDIR /app
RUN mvn clean package -DskipTests