## Notes 

1. Entity
Java class that is mapped to the database table
it should have public or protected No args constructor 
must be annotated with @Entity


Step 1 : 
Map class to database table 
@Table(name = "student")

Step 2 :
Map fields to database columns 
@Column - it is optional but best practice to use it 
reason - if you refactor these fields, then it will change the columns for others too

Primary Key : 
Unique key identified in a database table 
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

IDENTITY - assign primary key using database identity column
AUTO - pick an appropriate strategy for particular database
SEQUENCE - assign primary keys using database sequence
TABLE - assign primary keys using an underlying table to ensure uniqueness 
UUID - assign primary key using gloabl unique identifier
CUSTOM - You can also define your custom generation strategy 


Data access object (DAO)

JPA entity manager
JPA entity manager  and data source is automatically created by springboot 
based on application.properties 

Student DAO <------> Entity Manager <-----> Data Source <-----> Database 

JPA repository vs Entity Manager 
if you need low level control and flexibility , use entity manager 

if you want high level of abstraction use JPA repository.

@Transactional 
@Repository - annotate DAO , provides any JDBC related exceptions



## Database queries 

change the auto increment to start from some default value
ALTER TABLE student_tracker.student AUTO_INCREMENT = 3000;

delete all the data from table 
TRUNCATE student_tracker.student;


# JPQL 
we can query to fetch records from database 
all JPQL names as based on the entity names 

query to sort by last name in Entity Manager 
TypedQuery<Student> query = entityManager.createQuery("From Student order by firstName", Student.class);


## Hibernate 
add hibernate in applications.properties and it will create tables for you. 

spring.jpa.hibernate.ddl-auto=create
create, update, create-drop , none , validate 

schema migration tools : liquibase and flyway 

--test