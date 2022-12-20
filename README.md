# Postgres Spring Application in Docker

## Prerequisites

- Postman installed: https://www.postman.com/downloads/ for documentation
- pgAdmin installed: https://www.pgadmin.org/download/ for documentation

## Installation

- Clone repository into local directory
- Open a terminal in the directory and run `docker-compose up`
- Once the build is complete, the application should be running

## Testing with Postman

- Open a browser and access `localhost:8080` to display a message
- Open Postman and import `Postgres App.postman_collection.json` from the application directory
- Use Postman to test the POST endpoint by creating a user in the database
- Then use Postman to test the GET endpoint by returning the new user you have created

## Testing with pgAdmin

- Open pgAdmin and click _Add New Server_
- Name the server anything you wish, and then navigate to the _Connection_ tab
- Set **name** to `db`, set **Host name** to `localhost`, set **Port** to `5432`, set both **Username** and **Password** to `postgres`, and then click _Save_
- Once the db has been accessed, on the left-hand side click db -> Databases -> Schemas -> Tables -> customer -> Columns
- The columns should be `id`, `first_name`, and `last_name`
