mvn clean
mvn package
mvn package -DskipTests
docker build -t img_ms_ejemplo:V1 .
docker run -d -p 9090:9090 --env-file .env --name ms-ejemplo-v1  img_ms_ejemplo:V1
docker login
docker tag img_ms_ejemplo:V1 daniel0223/img_ms_ejemplo:V1
docker push daniel0223/img_ms_ejemplo:V1

#EC2  UBUNTU
sudo apt-get update
sudo apt-get install ca-certificates curl gnupg
sudo install -m 0755 -d /etc/apt/keyrings
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /etc/apt/keyrings/docker.gpg
sudo chmod a+r /etc/apt/keyrings/docker.gpg
echo \
  "deb [arch="$(dpkg --print-architecture)" signed-by=/etc/apt/keyrings/docker.gpg] https://download.docker.com/linux/ubuntu \
  "$(. /etc/os-release && echo "$VERSION_CODENAME")" stable" | \
  sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
sudo apt-get update
sudo apt-get install docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin
sudo apt-get update
sudo service docker start

sudo docker run -d -p 9090:9090 --name ms-ejemplo-v1 daniel0223/img_ms_ejemplo:V1
