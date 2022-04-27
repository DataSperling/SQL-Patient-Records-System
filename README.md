## PostgreSQL Patient Records System

The below picture shows an overview of this software application. It is an n-tier web-based patient records system using PostgreSQL as the back-end and excepts POST, PUT and DELETE requests over REST. The application is stratified into layers for archetypal classes, business logic and database access and is built using Spring-data-JPA. I use these repositories for learning so I apologise in advance if the description is too verbose.

![overView](https://user-images.githubusercontent.com/78074172/165515289-df484726-d788-4191-ac8e-e3e4b38ae2d3.png)

The aim of this repo is to learn about Spring-data-JPA and how it integrates with PostgreSQL. It
is adapted from a an application by Amigoscode aka Nelson.

www.amigoscode.com | https://www.youtube.com/c/amigoscode/videos


### Project Initialisation Using Spring: https://start.spring.io/

Downloading the following Maven Project gives you all the dependencies you need to start the
project: Spring-Web, Spring-Data-JPA and PostgreSQL-Driver.

![SpringInitializr](https://user-images.githubusercontent.com/78074172/154043285-64295a90-67e3-442e-9f84-176f58edf6bd.png)


### PostgreSQL Database
Mock customer data was generated using Mockaroo https://www.mockaroo.com/.

![mockaroo](https://user-images.githubusercontent.com/78074172/154044509-94494833-e3f6-4753-8ac3-f62644b0cf9c.png)

The generated SQL file is imported directly into a local PostgreSQL instance after creating the
appropriate user and database:

```
// create database
CREATE DATABASE patient_records;


// connect to database
\c patient_records


// create table with auto-incrementing serial number 
CREATE TABLE patient (
	    patient_id BIGSERIAL NOT NULL PRIMARY KEY,
	    first_name VARCHAR(50) NOT NULL,
	    middle_name VARCHAR(50),
	    last_name VARCHAR(50) NOT NULL,
	    gender VARCHAR(50) NOT NULL,
	    data_of_birth DATE NOT NULL,
	    address VARCHAR(50) NOT NULL,
	    postcode VARCHAR(50),
	    allergies VARCHAR(12),
	    diabetic VARCHAR(50)
    );

// read in the genmerated patient.sql file
\i /path/to/patient.sqlfile/on/local/machine/patient.sql 


// query database to check import worked, should return all entries (1000)
SELECT * FROM patient;
```


### Generating POST, GET, PUT and DELETE Requests

As this application functions over REST it requires http requests. These can be generated from a
suitable IDE: 

https://www.jetbrains.com/help/idea/http-client-in-product-code-editor.html

or by using Postman:

https://learning.postman.com/docs/getting-started/sending-the-first-request/.

The requests have to be formatted to match the archetypal patient class as follows:

### @PostMapping

PostMapping translates to `addPatient()` to the database. It is important the POST requests are 
formatted correctly as they must match the Patient.java class archetype. Below is an example of the formatting of a POST request to add a new patient to the database:

```
// Formatting of a valid POST request
{
    "id" : 3,
    "firstName" : "Francois",
    "secondName": null,
    "lastName" : "Durand",
    "gender" : "MALE",
    "age" : 38,
    "dateOfBirth" : "1984-06-22",
    "address" : "34 Av. Champs Elysee",
    "postcode" : "75008",
    "allergies" : "Tetracycline",
    "diabetic" : false
}
```

And here is the corresponding Patient.java class we must match:

```
// Patient.java class for POST request
public Patient(Long id,
                   String firstName,
                   String secondName,
                   String lastName,
                   String gender,
                   LocalDate dateOfBirth,
                   String address,
                   String postcode,
                   String allergies,
                   boolean diabetic) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.postcode = postcode;
        this.allergies = allergies;
        this.diabetic = diabetic;
    }
```

### @PutMapping and @DeleteMapping

PUT and DELETE mapping translate to `updatePatient()` and `deletePatient()` respectively. If we assume the server is running on `http://localhost:8080/api/v1/` below are examples of valid PUT
and DELETE requests:

```
//PUT request or updatePatient()
http://localhost:8080/api/v1/patient/1?lastName=Johnson&address=76%Park%Lane%London

//DELETE request or deletePatient()
 http://localhost:8080/api/v1/patient/1?lastName=Johnson
```





