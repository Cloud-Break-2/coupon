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
> curl -X POST "http://coupon-api:8080/v1/issue?userID=1&couponId=1" -H "Content-Type: application/json" -d '{}'
```

