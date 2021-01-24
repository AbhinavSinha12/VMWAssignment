FROM centos:7
RUN yum update -y
RUN yum install java-1.8.0-openjdk-devel -y
RUN mkdir -p /opt/abhinav/app/VMW/
RUN mkdir -p /opt/abhinav/config/
RUN mkdir -p /opt/abhinav/logs/
COPY target/assignment-0.0.1-SNAPSHOT.jar /opt/abhinav/app/VMW/
COPY starter /usr/local/bin
RUN  chmod +x /usr/local/bin/starter

EXPOSE 8080
ENTRYPOINT  starter
