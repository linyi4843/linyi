# docker部署为 jar包

FROM tomcat:9.0.11-jre8
COPY linyi-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8083
ENTRYPOINT ["/usr/bin/java","-jar","app.jar"]