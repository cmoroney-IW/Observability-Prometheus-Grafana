# Microservice in Kong

## Prerequisites

- VS Code installed
- Postman installed
- Docker Desktop installed and running on system

#### VS Code Settings

- Open VS Code, go to settings, and ensure Files: Eol is set to `\n`
- In the bottom right corner of VS Code on the status bar, ensure 'Select End of Line Sequence' is set to `LF`

## Basic Installation

- Clone this repository into a local directory
- Open `docker-compose.yml` and enter a username and password of your choice where prompted under environment; five total fields should be changed
- Open a terminal in the directory and run `docker-compose up --build` to set up the microservice
- Open a browser and enter `localhost:8002` to access the Kong dashboard

## Automating Kong endpoints

- Open a new terminal and run `cd Script`
- Run `docker-compose up --build` to run a script that automatically creates basic endpoints for the microservice in Kong
- The container should exit with code 0 and no errors, indicating that the script has run successfully
- Access the Kong dashboard at `localhost:8002` and observe that the endpoints have been created

## Testing

- Open Postman and import Microservice.postman_collection from this directory
- Test the microservice by creating, reading, and deleting customers from the database using the endpoints provided
