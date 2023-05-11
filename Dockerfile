FROM adoptopenjdk:17-jdk-hotspot
EXPOSE 8080
ADD ./boot/target/boot-0.0.1-SNAPSHOT.jar ./boot-0.0.1-SNAPSHOT.jar
CMD java -Djava.security.egd=file:/dev/./urandon -jar boot-0.0.1-SNAPSHOT.jar