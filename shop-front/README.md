# 수정 사항
- default.conf
- Dockerfile

# 소스코드 빌드
빌드되면, build 폴더 생성됨.
```
npm install
npm run build
```

# 도커컴포즈 실행 및 확인
도커 내부에 들어가서 확인하기
```
> docker compose up -d --build
> docker exec -it shop-front /bin/sh
> curl http://shop-back:80/products?page=0 
> curl http://coupon-api:80/hello
```

--------기타 참고


# 컨테이너 이미지 빌드
```
docker buildx create --use --name mynewbuilder
docker buildx use mybuilder
docker run --rm --privileged --platform linux/arm64 multiarch/qemu-user-static --reset -p yes


# v2.0 EKS url, DATABASE table 적용
# v2.1 modify Dockerfile URL localhost -> shop-back:8080
<<<<<<< HEAD
docker buildx build --platform linux/amd64,linux/arm64 -t cloudbreak6th/shop-front:v2.1 --push .
=======
# v2.2 CORS 적용
docker buildx build --platform linux/amd64,linux/arm64 -t cloudbreak6th/shop-front:v2.2 --push .
>>>>>>> e1a398d (20240905)
docker buildx build --platform linux/amd64,linux/arm64 -t cloudbreak6th/shop-front:latest --push .
```

Docker Desktop 설치 및 Buildx 활성화: `docker buildx create --use`로 빌더 생성.
QEMU 설정: 
docker run --rm --privileged multiarch/qemu-user-static --reset -p yes

로 멀티 아키텍처 지원 설정.
Dockerfile 작성: 표준 Dockerfile 작성.
멀티 아키텍처 빌드 및 푸시: docker buildx build --platform linux/amd64,linux/arm64 -t <your-image> --push .로 빌드 및 푸시.

-----------------


docker buildx build --platform linux/amd64,linux/arm64 -t cloudbreak6th/shop-front:v2.1 --push .