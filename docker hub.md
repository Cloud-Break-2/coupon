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

# shop-front (cloudbreak6th/shop-front:v2.2)
- v2.0 : REACT_APP_API_URL 환경변수 localhost
- v2.1 : REACT_APP_API_URL 환경변수 shop-back: 8080-
- v2.2 : Backend ALB 적용 버전 --2024.09.06 
  ```
  ENV REACT_APP_API_PATH=http://k8s-default-shopback-c8447eb4cd-128335560.ap-northeast-2.elb.amazonaws.com
  ENV REACT_APP_API_COUPON_URL=http://k8s-default-couponap-acba0908a2-2018995402.ap-northeast-2.elb.amazonaws.com
  ```


