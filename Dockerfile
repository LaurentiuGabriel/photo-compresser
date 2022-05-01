FROM openjdk:17-jdk-alpine
VOLUME /tmp
ADD target/photo-compresser-1.0-SNAPSHOT-jar-with-dependencies.jar photo-compresser-app.jar
ENV JAVA_OPTS="-classpath lib/*.jar"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /photo-compresser-app.jar" ]