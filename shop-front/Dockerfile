FROM --platform=$BUILDPLATFORM node:18 AS builder
WORKDIR /app
COPY package.json package-lock.json ./

# env.local
#ENV REACT_APP_API_PATH=http://localhost
#ENV REACT_APP_API_COUPON_URL=http://coupon-api:8080

# env.prod 환경 : 백엔드 API 서버 주소 - shop-back ALB endpoint
ENV REACT_APP_API_PATH=http://k8s-default-shopback-c8447eb4cd-128335560.ap-northeast-2.elb.amazonaws.com
ENV REACT_APP_API_COUPON_URL=http://k8s-default-couponap-acba0908a2-1422117942.ap-northeast-2.elb.amazonaws.com

RUN npm ci
COPY . .
RUN npm run build

# 실 환경에서는 nginx가 꼭 있어야 하는지가 의문임..
FROM nginx:alpine
COPY --from=builder /app/build /usr/share/nginx/html
COPY ./default.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]