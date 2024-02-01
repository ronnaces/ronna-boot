################################################
# Dockerfile
# @author KunLong-Luo
# @version 3.0.0
# @since 2023-03-16 10:50:00
################################################

FROM luokunlong/jdk:17-jdk-alpine-arthas

MAINTAINER luokunlong kunlong_luo@163.com

ENV LANG en_US.UTF-8

WORKDIR /luokunlong

EXPOSE 8080

COPY ./target/*.jar ./app.jar
COPY docker-entrypoint.sh ./

ENTRYPOINT ["sh", "./docker-entrypoint.sh"]