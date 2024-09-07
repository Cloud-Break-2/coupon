# 컨테이너 이미지 빌드
```
docker login 
docker buildx create --use --name mynewbuilder
docker buildx use mybuilder
docker run --rm --privileged --platform linux/arm64 multiarch/qemu-user-static --reset -p yes

-------------------
docker buildx build --platform linux/amd64,linux/arm64 -t cloudbreak6th/shop-front:v2.2 --push .

docker buildx build --platform linux/amd64,linux/arm64 -t cloudbreak6th/coupon-api:v2.1 --push .

docker buildx build --platform linux/amd64,linux/arm64 -t cloudbreak6th/shop-front:latest --push .
```

# shop-front (cloudbreak6th/shop-front:v2.2)
- v2.0 : REACT_APP_API_URL 환경변수 localhost
- v2.1 : REACT_APP_API_URL 환경변수 shop-back: 8080-
- v2.2 : Backend ALB 적용 버전 --2024.09.06

