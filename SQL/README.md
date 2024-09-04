# 확인 명령어 
```
❯ docker exec -it coupon-mysql mysql -u abcd -p

mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| coupon             |
| information_schema |
| performance_schema |
+--------------------+
3 rows in set (0.00 sec)

mysql> use coupon;
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Database changed 
mysql> show tables;  
+------------------+
| Tables_in_coupon |
+------------------+
| cart_tb          |
| coupon_issues    |
| coupons          |
| error_log_tb     |
| item_tb          |
| option_tb        |
| order_tb         |
| product_tb       |
| user_tb          |
+------------------+
9 rows in set (0.00 sec)

mysql> select * from <테이블명>;
```

# 이미지 빌드 
docker buildx create --use --name mynewbuilder
docker buildx use mybuilder
docker buildx inspect --bootstrap
docker run --rm --privileged multiarch/qemu-user-static --reset -p yes

# v2.0 EKS url, DATABASE table 적용
docker buildx build --platform linux/amd64,linux/arm64 -t cloudbreak6th/coupon-mysql:v2.0 --push .
docker buildx build --platform linux/amd64,linux/arm64 -t cloudbreak6th/coupon-mysql:latest --push .