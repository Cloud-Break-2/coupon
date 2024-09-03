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
# coupon-mysql 확인 
```
❯ docker exec -it coupon-mysql mysql -u abcd -p
Enter password: 1234
mysql> show databases;
mysql> use coupon;
mysql> show tables;
mysql> select * from <테이블명>; 
// 총 테이블 9개 존재, 데이터도 있는지 확인하기 
```

# coupon-api 확인
``` 
# 도커 쉘 실행
> docker exec -it coupon-api /bin/bash

# mysql 확인
> mysql -h coupon-mysql -P 3306 -u abcd -p
> show databases;
> use coupon;
> show tables;
> select * from coupon_issues;
> select * from coupons;

# redis 확인
> redis-cli -h coupon-redis -p 6379
> ping
PONG

# 백엔드 통신 확인 

# 프론트 통신 확인 
```

# shop-front 확인  
```
> docker exec -it shop-front /bin/sh
> curl http://shop-back:80/products?page=0
> curl http://coupon-api:80/hello
```

# shop-back 확인
```
#도커 내부가서 
> docker exec -it shop-back /bin/bash
> curl http://shop-back:80/products?page=0

# mysql 확인 :
> mysql -h coupon-mysql -P 3306 -u abcd -p
> 1234
> show databases;
> use coupon;
> show tables;
> show tables;
> select * from coupon_issues;
> select * from coupons;
```

----
# [부록]도커 관련 기본 명령어
```
docker inspect <container_id> # 컨테이너 정보 확인
docker logs -f <container_id> # 컨테이너 로그 확인  
docker exec -it <container_id> /bin/sh # 컨테이너 접속
```

mysql-client, redis-tools 설치
```
sudo apt-get update
sudo apt-get install -y mysql-client redis-tools
```