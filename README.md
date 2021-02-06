* sudo docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=1234 -e MYSQL_DATABASE=ServiceOrder -e MYSQL_USER=UserOS -e MYSQL_PASSWORD=2525 mysql
* sudo docker exec -it container_name /bin/bash