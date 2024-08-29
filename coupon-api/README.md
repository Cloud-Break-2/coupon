# 수정 사항
- coupon-XXX/src/main/resources/application-api.yml 수정: mysql, redis 주소 변경

# 소스코드 빌드 
- mysql, redis 먼저 실행 및 연결이 되어야 빌드가 가능하다.
./gradlew build -x test 
cd ~/coupon-api/coupon-api/build/libs
java -jar -Dspring.profiles.active=local coupon-api.jar <- 이미지 빌드할때 해당 버전으로 해야하지 않을까? yes, local


확인: ./coupon-api/build/libs/coupon-api.jar 생성확인 

# 도커컴포즈 실행 및 확인
docker-compose up -d

# 확인
curl <url>:8080/hello
도커 내부로 들어가서 디비, 레디스 잘 있는지 확인 
포스트맨으로 post 보내보기 

--------기타 참고


# 컨테이너 이미지 빌드
docker buildx create --use --name mynewbuilder
docker buildx use mybuilder
docker buildx inspect --bootstrap
docker run --rm --privileged multiarch/qemu-user-static --reset -p yes

docker buildx build --platform linux/amd64,linux/arm64 -t cloudbreak6th/shop-front:latest --push .

