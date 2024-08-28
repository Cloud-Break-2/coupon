# 수정 사항
- .env REACT_APP_API_URL = http://localhost:8082
- default.conf 추가
- Dockerfile

# 소스코드 빌드
npm install
npm run build
빌드되면, build 폴더 생성됨.
//네고왕 이미지 잘 가져오는지 확인하기

# 도커컴포즈 실행 및 확인
docker-compose up -d

# 확인
curl localhost


--------기타 참고


# 컨테이너 이미지 빌드
docker buildx create --use --name mynewbuilder
docker buildx use mybuilder
docker buildx inspect --bootstrap
docker run --rm --privileged multiarch/qemu-user-static --reset -p yes

docker buildx build --platform linux/amd64,linux/arm64 -t cloudbreak6th/shop-front:latest --push .

-----------------
작업 해야하는 것 
ㅁ nginx 자체 웹페이지 형태로 할수 있도록 하기 
