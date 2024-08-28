# 도커 관련 기본 명령어 
docker-compose up -d # 도커 컨테이너 실행
docker ps -a
docker-compose down

------
docker inspect <container_id> # 컨테이너 정보 확인
docker logs -f <container_id> # 컨테이너 로그 확인  
docker exec -it <container_id> /bin/sh # 컨테이너 접속 

------


