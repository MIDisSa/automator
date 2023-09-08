# Automator
The “Automator” will function as a backend in our system. It takes in the clean data in csv form and lets the model run using that data via the controlling API. It also connects to the “Optimizer” via the CLI. It is connected to the User Interface of our system over a REST API.

![role of the automator in the architecture](architecture.png)

## To Run
To run the application:\
```mvn spring-boot:run``` in terminal or run from ```AutomatorApplication.java``` using IDE created "run" button

To run the services:\
```curl localhost:8080``` in a separate terminal window or open 'localhost:8080/*command*' in browser

To run executable .jar:\
In terminal navigate to .../automator and run ```java -jar target/automator-0.0.1-SNAPSHOT.jar``` (might be Windows specific)

To run in Docker container:\
Open Docker Desktop app.\
In terminal navigate to .../automator and run ```docker build -t automator .```. This builds the Docker image based on the Dockerfile in the automator directory.
Then run ```docker run -it -p 8080:8080 automator```. This starts up the Docker container.

Functionality:\
When running the Spring Boot app as an executable jar, everything should be working as intended, on Windows at least. Not sure about UNIX-Systems.\
When running in a Docker container, currently /results is working, optimization commands are somehow not executed though. Might be a problem with the UNIX-System commands.


## How to make changes
Whenever the Java-code is changed, delete old .jars in the target folder and re-package the code using maven (should be possible in all IDEs, for me IntelliJ worked best).
Then rebuild Docker image to apply the changes.
