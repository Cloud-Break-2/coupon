FROM --platform=$BUILDPLATFORM node:18 AS builder
WORKDIR /app
COPY package.json package-lock.json ./


# v2.0 : REACT_APP_API_URL 환경변수 localhost
# v2.1 : REACT_APP_API_URL 환경변수 shop-back: 8080

# REACT_APP_API_URL : 개발환경에서는 localhost, 운영환경에서는 백엔드 API 서버 주소
ENV REACT_APP_API_URL=http://localhost
#ENV REACT_APP_API_URL=http://shop-back:8080

ENV REACT_COUPON_APP_API_URL=http://coupon-api:8080

RUN npm ci
COPY . .
RUN npm run build

FROM nginx:alpine
COPY --from=builder /app/build /usr/share/nginx/html
COPY ./default.conf /etc/nginx/conf.d/default.conf
CMD ["nginx", "-g", "daemon off;"]
EXPOSE 80
