# JavaFuturesDemo
A project that demonstrates how to use Java Futures and CompletableFutures

# Use cases

[MORE TO COME]

# Getting the code up and running

The project is Java code that runs in the Maven framework.

**Step 1:**  Confirm Java is installed.

```bash
java -version
```

You'll get output similar to the following. If not, [install the Java SDK](https://openjdk.org/install/).

```text
openjdk version "21" 2023-09-19
OpenJDK Runtime Environment (build 21+35-2513)
OpenJDK 64-Bit Server VM (build 21+35-2513, mixed mode, sharing)

```

---

**Step 2:** Confirm Maven is installed on your host machine

```bash
mvn --version
```

You'll get output similar to the following. If not, [install Maven](https://maven.apache.org/install.html).

```
Maven home: /usr/share/maven
Java version: 18.0.2, vendor: Oracle Corporation, runtime: /usr/lib/jvm/jdk-18.0.2
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "5.19.0-46-generic", arch: "amd64", family: "unix"
```

---

**Step 3:** Do some Maven housecleaning

Run the following command in a terminal window to create a fresh Maven application environment:
```bash
mvn clean package install
```

## Running the Simple Futures use case

Execute the following code in a terminal window to run the Travel use case code:

```bash
mvn exec:java -Dexec.mainClass="futuresdemo.SimpleFutureDemo"
```

You'll get output similar to the following:

```text
Waiting for Airline at 2024-02-26 22:25:31 
Waiting for Airline at 2024-02-26 22:25:31 
Waiting for Airline at 2024-02-26 22:25:31 

Waiting for Airline at 2024-02-26 22:25:32 
--------
Result: Airline is confirmed at 2024-02-26 22:25:32
--------
Waiting for Hotel at 2024-02-26 22:25:32 
Waiting for Hotel at 2024-02-26 22:25:32 
Waiting for Hotel at 2024-02-26 22:25:32 
Waiting for Hotel at 2024-02-26 22:25:33 
--------
Result: Hotel is confirmed at 2024-02-26 22:25:33
--------
Waiting for Car Rental at 2024-02-26 22:25:33 
Waiting for Car Rental at 2024-02-26 22:25:33 
Waiting for Car Rental at 2024-02-26 22:25:34 
Waiting for Car Rental at 2024-02-26 22:25:34 
--------
Result: Car Rental is confirmed at 2024-02-26 22:25:34
--------
```


## Running the Chained Sequential CompletableFutures use case:

Execute the following code in a terminal window to run a set of CompletableFutures that are chained together in a sequential manner:

```bash

```bash
mvn exec:java -Dexec.mainClass="futuresdemo.SimpleChainedCompletableFutureDemo"
```

You'll get output similar to the following:

```text
Running a chained business process

--------
Result: Airline is confirmed at 2024-02-26 22:27:47
--------
--------
Result: Hotel is confirmed at 2024-02-26 22:27:48
--------
--------
Result: Car Rental is confirmed at 2024-02-26 22:27:49
--------
```

## Running the CompletableFutures in parallel:

Execute the following code in a terminal window to run a set of CompletableFutures in parallel:

```bash

```bash
mvn exec:java -Dexec.mainClass="futuresdemo.SimpleParallelCompletableFutureDemo"
```

You'll get output similar to the following:

```text
Running a set of simple Parallel CompletableFutures

Making a reservation for Hotel at 2024-03-04 22:49:41.774
Making a reservation for Airline at 2024-03-04 22:49:41.774
Making a reservation for Car Rental at 2024-03-04 22:49:41.774
Ending a reservation for Hotel at 2024-03-04 22:49:42.832
Ending a reservation for Car Rental at 2024-03-04 22:49:42.831
Ending a reservation for Airline at 2024-03-04 22:49:42.832
--------
Result: Airline is confirmed at 2024-03-04 22:49:42
--------
--------
Result: Hotel is confirmed at 2024-03-04 22:49:42
--------
--------
Result: Car Rental is confirmed at 2024-03-04 22:49:42
--------

Process finished with exit code 0
```