# Monitoring APIs using Prometheus + Grafana

## Prerequisites

- VS Code installed
- Postman installed
- Docker Desktop installed and running on system

#### VS Code Settings

- Open VS Code, go to settings, and ensure Files: Eol is set to `\n`
- In the bottom right corner of VS Code on the status bar, ensure 'Select End of Line Sequence' is set to `LF`

## Basic Installation

- Clone this repository into a local directory
- Open `docker-compose.yml` and enter a username and password of your choice where prompted by comments; seven total fields should be changed
- Open a terminal in the directory and run `docker-compose up --build` to set up the microservice
- Open a browser and enter `localhost:8002` to access the Kong dashboard

## Automating Kong endpoints

- Open a new terminal and run `cd Script`
- Run `docker-compose up --build` to run a script that automatically creates basic endpoints for the microservice in Kong
- The container should exit with code 0 and no errors, indicating that the script has run successfully
- Access the Kong dashboard at `localhost:8002` and observe that the endpoints have been created

## Prometheus Plugin in Kong

- Enter `localhost:8002` in a browser and navigate to the workspace
- Find Plugins on the left-hand side and click Install Plugin
- Search for 'Prometheus', click Enable, tick all config boxes, and finally click Install

## Setting up observability

- Enter `localhost:3000` in a browser and login to the Grafana dashboard using the username and password you entered in the docker-compose.yml file
- At the homepage, click 'Add your first data source' and then select Prometheus
- Name the data source what you wish, in the URL field enter `http://prometheus:9090`, and then scroll down to click on Save & Test, which should result in a message saying that the data source is working
- Next, on the left-hand sidebar hover over the icon with four boxes and click + Import
- Click Upload JSON file and upload `microservice-dashboard.json` found within the prometheus folder of this directory
- Select the data source previously created and then click Import. You will be directed to the dashboard page used to monitor the microservice APIs

## Testing

- Open Postman and import Microservice.postman_collection from this directory
- Test the microservice by creating, reading, and deleting customers from the database using the endpoints provided
- Metrics can be observed by navigating to the dashboard previously created at `localhost:3000`
