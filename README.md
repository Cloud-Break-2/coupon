# install.sh 
```
chmod +x install.sh
sudo ./install.sh
```

# docker-compose 실행 및 확인
```
docker-compose up -d --build # 도커 컨테이너 실행 및 빌드 
docker ps -a
docker-compose down # 도커 컨테이너 종료
```

# 백엔드 통신 확인 확인완료 ✅ 프론트 -> 백엔드
``` 
> dcoerk exec -it shop-front /bin/sh 
> curl http://shop-back:8080/products?page=0 
> curl http://coupon-api:8080/hello  
> curl -X POST "http://coupon-api:8080/v1/issue?userID=1&couponId=1" -H "Content-Type: application/json" -d '{}' 
```

# MySQL 및 redis 확인 ✅ 백엔드 -> 디비 
```
❯ docker exec -it shop-back /bin/bash
❯ docker exec -it coupon-api /bin/bash

(공통확인)
mysql -h coupon-mysql -P 3306 -u abcd -p
Enter password: 1234
mysql> show databases;
mysql> use coupon;
mysql> show tables;
mysql> select * from <테이블명>; 
// 총 테이블 9개 존재, 데이터도 있는지 확인하기 

> redis-cli -h coupon-redis -p 6379
> ping
PONG
```



----
# [부록]도커 관련 기본 명령어
```
docker exec -it <container_id> /bin/sh # 컨테이너 내부접속
docker inspect <container_id> # 컨테이너 정보 확인
docker logs -f <container_id> # 컨테이너 로그 확인  
```

mysql-client, redis-tools 설치
```
sudo apt-get update
sudo apt-get install -y mysql-client redis-tools
```