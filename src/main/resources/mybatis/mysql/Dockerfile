FROM mysql
ENV MYSQL_ROOT_PASSWORD=password
ARG SCRIPT
COPY $SCRIPT /docker-entrypoint-initdb.d/