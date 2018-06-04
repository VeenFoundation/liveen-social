FROM tomcat:8.5-alpine

COPY target/boot-qna-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT##42.war

