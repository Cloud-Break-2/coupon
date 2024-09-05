#!/bin/sh

# Installation -----------------------------------------
yum update -y
yum install -y git 
yum install -y curl

<<<<<<< HEAD

## docker&docker-compose 
yum install -y docker 
usermod -a -G docker ec2-user 
id ec2-user
newgrp docker
systemctl start docker
systemctl enable docker
service docker start

## docker-compose 
curl -L https://github.com/docker/compose/releases/latest/download/docker-compose-$(uname -s)-$(uname -m) -o /usr/local/bin/docker-compose
chmod +x /usr/local/bin/docker-compose

# JAVA ENV --------------------------------------------
# yum install -y java-17-amazon-corretto-devel

=======
## docker&docker-compose 
yum install -y docker 
sudo usermod -aG docker ec2-user
id ec2-user
newgrp docker
sudo systemctl enable --now docker
service docker start

# Compose Plugin
sudo mkdir -p /usr/local/lib/docker/cli-plugins/
sudo curl -SL "https://github.com/docker/compose/releases/latest/download/docker-compose-linux-$(uname -m)" -o /usr/local/lib/docker/cli-plugins/docker-compose
sudo chmod +x /usr/local/lib/docker/cli-plugins/docker-compose


# JAVA ENV --------------------------------------------
# yum install -y java-17-amazon-corretto-devel
#java -version
>>>>>>> e1a398d (20240905)

# Version Check ---------------------------------------
git --version 
curl --version 
docker --version 
<<<<<<< HEAD
docker-compose --versions
java -version
=======
docker compose version

>>>>>>> e1a398d (20240905)
