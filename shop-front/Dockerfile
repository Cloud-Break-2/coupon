FROM --platform=$BUILDPLATFORM node:18 AS builder
WORKDIR /app
COPY package.json package-lock.json ./
ENV REACT_APP_API_URL=http://localhost
# ENV REACT_APP_API_URL=http://localhost:80 # For Kubernetes

# CHECK EKS - svc:port for api 🙏 강사님 확인 후에 진행 //개발환경에서 확인은 어떻게?
ENV REACT_APP_API_URL=http://shop-back:80
#ENV REACT_APP_API_URL_COUPON=http://coupon-api:80 <- 여기 굳이 없어도 될듯 fetch로 직접 요청하므로

RUN npm ci
COPY . .
RUN npm run build

FROM nginx:alpine
#COPY default.conf /etc/nginx/conf.d/default.conf
COPY --from=builder /app/build /usr/share/nginx/html
COPY ./default.conf /etc/nginx/conf.d/default.conf
CMD ["nginx", "-g", "daemon off;"]
EXPOSE 80
