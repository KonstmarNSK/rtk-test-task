## Тестовое задание "Сервис перенаправления"

Сборка и запуск:
В корневом каталоге (где этот файл) выполнить 

> mvn package -DskipTests

Будут собраны jar-файлы в linkservice/service/target и redirectservice/target


## Запуск через докер:
В папке docker есть docker-compose.yml. Надо перейти в каталог docker и выполнить

> docker compose up

После чего на порту 8083 будет доступен сервис коротких ссылок, на порту 8084 - сервис перенаправления.
Также будет поднят оракл (докер образ большой и долго стартует)


## Запуск не через докер:

### Сервис коротких ссылок:

> java -DDB_URL=<Путь к БД> -DDB_USER=<пользователь> -DDB_PWD=<пароль> -DSERVER_PORT=<Порт> -jar ./linkservice/service/target/linkservice-0.0.1-SNAPSHOT.jar

Дефолтные значения:
> DB_URL=jdbc:oracle:thin:@db-oracle:1521/XEPDB1
DB_USER=pdbadmin
DB_PWD=123
SERVER_PORT=8080

Схема в БД должна быть чистая, пользователь должен иметь возможность создавать таблицы и sequence (при запуске работает flyway).

### Сервис перенаправления:

> java -DLINK_SERVICE_URL=<Адрес сервиса коротких ссылок> -DSERVER_PORT=<Порт> -jar ./redirectservice/target/redirectservice-0.0.1-SNAPSHOT.jar

Дефолтные значения: 

> SERVER_PORT=8080
LINK_SERVICE_URL=http://link-service:8080

## Тесты:

После того, как сервисы будут запущены, можно запустить тесты:
из корневого (этого) каталога выполнить

>mvn test -pl tests

Тестам нужны адреса сервисов, они указаны в property-файле в папке tests/src/test/resources