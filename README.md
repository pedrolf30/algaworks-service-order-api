# Service Order API

## Requirements

* Linux
* Git
* Java 11
* Docker
* IntelliJ Community
* Maeven

## DataBase

### Docker and MySQL


```shell script
 sudo docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=1234 -e MYSQL_DATABASE=ServiceOrder -e MYSQL_USER=UserOS -e MYSQL_PASSWORD=2525 mysql
```
```shell script
sudo docker exec -it container_name /bin/bash
```

## Spring Boot

* [https://start.spring.io/](https://start.spring.io/)
+ Java 11
+ Maven Project
+ Jar
+ Spring Web
+ Spring Data JPA
+ MySQL Driver
+ ModelMapper

#### Projeto feito por [Pedro Ferrareso](https://github.com/pedrolf30) com apoio de [Algaworks](https://www.algaworks.com/)




