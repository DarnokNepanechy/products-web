# products-web
web-app на Spring

Возвращает страницы со списком продуктов из базы данных, отфильтрованных по цене и названию. 

Можно добавлять новые продукты, редактировать имеющиеся и удалять (CRUD). 

Стэк технологий:
  Java
  Maven
  MVC
  HTTP
  Flyway
  Spring Boot
  Spring Data 
  Thymeleaf
  PostgreSQL 12

К приложению можно получить доступ по url: http://localhost:8090/products

Сервер обрабатывает http запросы клиента и возвращает страницы с контентом из базы данных, собранные по html шаблонам в папке templates.

В страницах html используется язык thymeleaf, который помогает связать java объекты и фронтэнд.

С помощью плагина Flyway можно провести миграцию БД по SQL запросу V1__init.sql

В приложении был использован фреймворк Spring Boot
Структура сервера построена по паттерну MVC:
Controller принимает http запросы, вытягивает атрибуты из url и делигирует методы Service
Service уже непосредственно выполняет поставленную задачу, и просит Repository вытащить из базы данных нужную информацию
Repository выполненна в виде интерфейса, унаследованного от JPARepository, в котором имеется обширное количество методов для работы с БД
Config хранит конфигурацию приложения
Product - класс, по которому собираются объекты-продукты. Там куча аннотаций для hibernate, чтобы тот мог перенести его в БД и наоборот
DemoApplication - главный класс с точкой входа в программу (метод main)