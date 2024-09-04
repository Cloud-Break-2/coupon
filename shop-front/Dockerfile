FROM --platform=$BUILDPLATFORM node:18 AS builder
WORKDIR /app
COPY package.json package-lock.json ./
#ENV REACT_APP_API_URL=http://localhost

# CHECK EKS - svc:port for api
ENV REACT_APP_API_URL=http://shop-back:8080
ENV REACT_APP_API_URL_COUPON=http://coupon-api:8080

RUN npm ci
COPY . .
RUN npm run build

FROM nginx:alpine
#COPY default.conf /etc/nginx/conf.d/default.conf
COPY --from=builder /app/build /usr/share/nginx/html
COPY ./default.conf /etc/nginx/conf.d/default.conf
CMD ["nginx", "-g", "daemon off;"]
EXPOSE 80
