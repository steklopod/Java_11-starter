[![Build Status](https://travis-ci.com/steklopod/Java_11-starter.svg?branch=master)](https://travis-ci.com/steklopod/Java_11-starter)
[![Inline docs](http://inch-ci.org/github/dwyl/hapi-auth-jwt2.svg?branch=master)](http://inch-ci.org/github/dwyl/hapi-auth-jwt2)
## Java 11, Spring Boot 2, Gradle 5, Docker, Postgres, Travis.ci, Junit 5


### Docker Compose

![alt text](https://github.com/steklopod/Docker_visits/blob/master/screenshots/compose.png "compose")

`Docker Compose` - это инструмент для определения и запуска приложений с несколькими контейнерами `Docker`.

Определяет службы, составляющие ваше приложение, в [docker-compose.yml](https://docs.docker.com/compose/compose-file/), 
чтобы они могли работать вместе в изолированной среде.

*`docker-compose.yml`:*

```yaml
version: '3.5'
services:
  redis-server:
    image: 'redis'
  node-app:
    build: .
    ports:
      - "4001:8081"
```

Порт `4001` - наружный, `8081` - порт внутри контейнера.

> Запуск:

```docker
docker-compose up --build
```

Флаг `--build` делает сборку каждый раз:

![alt text](https://github.com/steklopod/Docker_visits/blob/master/screenshots/docker-compose_up.png "docker-compose_up")

Зайти по адресу: [http://192.168.99.100:4001/](http://192.168.99.100:4001/)


>[Остановка](https://docs.docker.com/compose/reference/down/):

```docker
docker-compose down
```
___

### Dockerfile 

`Dockerfile` - это простой текстовый файл, содержащий команды, которые пользователь может вызвать для сборки изображения.


*`Dockerfile`:*

```dockerfile
FROM node:alpine

WORKDIR '/app'

COPY package.json .
RUN npm install
COPY . .

CMD ["npm", "start"]
```


> [Сборка](https://docs.docker.com/engine/reference/commandline/build/#tag-an-image--t) Если не используем `docker-compose`.
(_не забываем точку в конце_):

```docker
docker build -t steklopod/visits:latest .
```

![alt text](https://github.com/steklopod/Docker_visits/blob/master/screenshots/Docker_build.jpg "Docker_build")


>[Запуск](https://docs.docker.com/engine/reference/run/)

```docker
docker run -d -p 8080:8080 steklopod/visits
```

>[Остановка](https://docs.docker.com/engine/reference/commandline/stop/)
```docker
docker ps
```
скопировать `id` контейнера, а затем:
```docker
docker stop my_container_ID
```
___


#### Замена `192.168.99.100` -> localdocker

Чтобы изменить адрес `192.168.99.100:4001` на [localdocker:4001](http://localdocker:4001) необходимо в
файле `C:\Windows\System32\Drivers\etc\hosts` добавить строку:

```text
192.168.99.100    localdocker
```

#### Уточнить хост по умолчанию:

```bash
docker-machine ip default
```
___

#### Обновить докер:
```docker
docker-machine upgrade default
```

___

#### Gradle Versions Plugin - Актуальные версии библиотек

Чтобы узнать актуальность версий с помощью плагина [Gradle Versions Plugin](https://github.com/ben-manes/gradle-versions-plugin) 
библиотек необходимо запустить таску gradle: `help` -> `dependencyUpdates`

#### Чтобы убить процесс на порту 8080 (Windows):
```
1. netstat -ano | findstr 8085
2. taskkill /pid @НОМЕР_ПОРТА@ /F
``` 
