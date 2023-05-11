FROM maven:3.8.3-openjdk-17
EXPOSE 8080
ADD ./boot/target/boot-0.0.1-SNAPSHOT.jar ./boot-0.0.1-SNAPSHOT.jar
CMD java -Djava.security.egd=file:/dev/./urandon -jar boot-0.0.1-SNAPSHOT.jar