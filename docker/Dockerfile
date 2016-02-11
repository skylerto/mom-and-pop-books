FROM ubuntu

# Update Ubuntu
RUN apt-get update && apt-get -y upgrade

# Install Java
RUN apt-get -y install openjdk-7-jdk

# Install Tomcat
RUN apt-get -y install tomcat7
EXPOSE 8080

RUN mkdir /webapps
RUN cp -r /var/lib/tomcat7/webapps/ROOT /webapps
RUN rm -rf /var/lib/tomcat7/webapps
RUN ln -sf /webapps /var/lib/tomcat7/webapps
VOLUME /webapps

ADD startup.sh /opt/
RUN chmod +x /opt/startup.sh

ENTRYPOINT ["/opt/startup.sh"]
