FROM tomcat:7-jre8

# Create /webapps volume
RUN rm -rf /usr/local/tomcat/webapps
RUN ln -sf /webapps /usr/local/tomcat/webapps
VOLUME /webapps

# Get going
CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]
