FROM java:8-jre
RUN mkdir -p /application/target && ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone
WORKDIR /application
COPY target /application/target
EXPOSE 8000
ENTRYPOINT ["java" ,"-jar", "/application/target/mt-cloud-eureka.jar"]