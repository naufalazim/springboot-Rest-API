# SpringBoot Rest API
My learning journey develop applications with Spring Boot 

## My Learning
- Develop with SpringBoot
- Create
- Edit
- Delete
- Get
- Search Query
- Connect with MySQL

## Prerequisite
- Build with Java11 but compatible with Java17
- Database with MySQL

### Spring Stereotype Annotations
@Component:
- @ Service
- @ Repository
- @ Controller
- @ Entity

## Setup
Database: application.properties

   ```shell
   # MySQL database connection settings
    spring.datasource.url=jdbc:mysql://localhost:3306/{Your_database_name}
    spring.datasource.username=root
    spring.datasource.password=
    
    # Hibernate settings
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
    
    spring.jpa.hibernate.ddl-auto=update
    
    # (Optional) Hibernate settings for showing SQL queries in the console (for development/debugging)
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.format_sql=true

