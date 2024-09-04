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

# MySQL 및 redis 확인
```
❯ docker exec -it coupon-mysql mysql -u abcd -p  // 방법1. mysql 직접접속
❯ docker exec -it <컨테이너명> /bin/bash // 방법2. 컨테이너 내부로 들어가서 mysql 접속 
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

# 백엔드 통신 확인
``` 
> curl http://shop-back:80/products?page=0
> curl http://coupon-api:80/hello
> curl -X POST "http://coupon-api:8080/v1/issue?userID=1&couponId=1" -H "Content-Type: application/json" -d '{}'
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