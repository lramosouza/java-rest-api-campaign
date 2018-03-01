#Frameworks e Tecnologias 
- Java 8
- Spring Boot
- Tomcat (provido pelo próprio Spring Boot)
- Mongo DB
- Spring Data
- Swagger
- Maven
- Lombok

#Arquitetura do projeto
- Aplicação spring boot que contém uma RESTful que consome e response em formato JSON 
- Camadas:
Controller > Component > Service > Repository
- Banco de Dados Mongo DB - utilizando o serviço de cloud  MLab

#Para rodar o projeto é necessário:
- Java 8
- Maven
- Lombok instalado na IDE

#Execução do projeto
Maven: 
clean install
clean package spring-boot:run

#Documentação da API
http://localhost:8082/swagger-ui.html 
