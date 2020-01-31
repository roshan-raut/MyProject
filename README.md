### MyProject

# Getting Started
This is a plug and play spring boot appication which is used to upload csv file contaning five columns.
The csv file contains information about the users, outlets and locations.
The uploaded information is stored in the mysql databse for further use.
The whole application is dockerised.

### How to Run and Stop the application
For running the application go to MyProject application folder which contains docker-compose.yml file and run the below command

    $docker-compose up

for stopping it run below command

    $docker-compose down

### Testing of Apllication
To check whether our application is running or not you can go to the below url and you can upload the csv file, you can use the sample csv file provided in project customers.csv

    http://localhost:9090/
   
### Checking logs
For checking the application logs you can run the docker commands on respective docker containers(application and database) which are generated from respective images.

    $docker logs <container-name-of-app>
    $docker logs <container-name-of-database>

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/maven-plugin/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/reference/htmlsingle/#production-ready)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
