# Running Database and API with Docker Compose

## Database up
To start the database, follow these steps:

Navigate to the directory containing the database docker compose file:
```
cd docker/database
```

Run the following command

```
docker-compose up
```

## Database and backend up

Navigate to the directory containing the database and api configuration docker compose file:
```
cd docker/backend
```

Run the following command

```
docker-compose up
```

## Verification
To verify that the application is running
```
docker ps
```
## Stop

Navigate to the directory containing each Docker Compose file.

Run the following command for each directory:
```
docker-compose down
```
