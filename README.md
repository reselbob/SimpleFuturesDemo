# JavaFuturesDemo
A project that demonstrates how to use Java Futures

# Use cases

There are two use cases. The first is a travel use case that runs Hotel, Airline and Car Rental reservations in 
parallel.

![travel-sequence-01](https://github.com/reselbob/JavaFuturesDemo/assets/1110569/a5d4c8f0-7ed2-4a5d-9491-e68dc30a043c)



The second use case is a commerce scenario that runs futures in two sequential styles. The first style is to run the activities in the use case as a sequence of blocking `CompletableFuture<T>`s.

![sequence-commerce-01](https://github.com/reselbob/JavaFuturesDemo/assets/1110569/f5b698a4-8454-4dc0-862e-97d1cf5f4d7d)


The second style runs the activites a a chain of blocking `CompletableFuture<T>`s.

![chained-commerce-01](https://github.com/reselbob/JavaFuturesDemo/assets/1110569/16f8726a-6eaa-44a5-8d3a-54c10e71469f)


In both styles, the sequence of futures gets an order and then pays for the order, ships the order, delivers the order and then finally confirms the order.


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

Execute the following code in a terminal window to run the Chained Commerce use case code:

```bash
mvn exec:java -Dexec.mainClass="futuresdemo.SimpleCompletableFutureDemo"
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
