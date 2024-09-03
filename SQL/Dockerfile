FROM --platform=$BUILDPLATFORM mysql:8.0 AS builder
WORKDIR /docker-entrypoint-initdb.d
COPY data.sql /docker-entrypoint-initdb.d/
CMD ["mysqld", "--character-set-server=utf8mb4", "--collation-server=utf8mb4_unicode_ci", "--explicit_defaults_for_timestamp=1"]

