# Process Runner Machine Calculation

Java Console Application to find number machine required for list of process that has start time & end time


## Requirements 

Linux or Windows bash shell

- Java 1.8.0.x
- Maven 3.5.3

## Run the application

Clone the repo. Build the repo using Maven.

```
mvn clean package
```

After successful build, jar(process-runner-calc-1.0-SNAPSHOT.jar) will be created under target directory.

#Execute

```
java -jar target\process-runner-calc-1.0-SNAPSHOT.jar
```

Enter the input in the console & press ENTER. Input must list of processes in array list.

For example :
[[1,5] ,[2,4], [4,5]]

#Test

Test cases can be found under 'src\test\java' folder

Run Test
```
mvn test
```


