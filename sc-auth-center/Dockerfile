FROM java:8
VOLUME /tmp
ADD ./target/sc-auth-center-0.0.1-SNAPSHOT.jar /app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8083
ENTRYPOINT ["java","-jar","/app.jar"]