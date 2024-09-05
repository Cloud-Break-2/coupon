FROM --platform=$BUILDPLATFORM node:18 AS builder
WORKDIR /app
COPY package.json package-lock.json ./

# local 개발환경
ENV REACT_APP_API_URL=http://localhost
ENV REACT_APP_COUPON_APP_URL=http://coupon-api:8080
# ENV REACT_APP_API_URL=http://localhost:8080 # For Kubernetes


RUN npm ci
COPY . .
RUN npm run build

FROM nginx:alpine
COPY --from=builder /app/build /usr/share/nginx/html
COPY ./default.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]