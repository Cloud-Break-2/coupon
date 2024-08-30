#!/bin/sh

# Installation -----------------------------------------
yum update -y
yum install -y git 
yum install -y curl

## docker&docker-compose 
yum install -y docker 
usermod -a -G docker ec2-user 
id ec2-user
newgrp docker
systemctl start docker
systemctl enable docker
service docker start

## docker-compose 
sudo curl -L https://github.com/docker/compose/releases/latest/download/docker-compose-$(uname -s)-$(uname -m) -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose
docker-compose version

# JAVA ENV --------------------------------------------
yum install -y java-17-amazon-corretto-devel


# Version Check ---------------------------------------
git --version 
curl --version 
docker --version 
docker-compose --versions
java -version