# 수정 사항
- default.conf
- Dockerfile

# 소스코드 빌드
```
npm install
npm run build
```

# 도커컴포즈 실행 및 확인
```
> docker compose up -d --build
> docker exec -it shop-front /bin/sh
> curl http://shop-back:80/products?page=0 
> curl http://coupon-api:80/hello
```

# 컨테이너 이미지 빌드
```
docker buildx create --use --name mynewbuilder
docker buildx use mybuilder
docker run --rm --privileged --platform linux/arm64 multiarch/qemu-user-static --reset -p yes


# v2.0 EKS url, DATABASE table 적용
# v2.1 modify Dockerfile URL localhost -> shop-back:8080
# v2.2 CORS 적용
docker buildx build --platform linux/amd64,linux/arm64 -t cloudbreak6th/shop-front:v2.2 --push .
docker buildx build --platform linux/amd64,linux/arm64 -t cloudbreak6th/shop-front:latest --push .
```