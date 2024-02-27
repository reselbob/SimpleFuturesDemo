#!/bin/bash

mvn clean package install

mvn exec:java -Dexec.mainClass="futuresdemo.SimpleFutureDemo"

mvn exec:java -Dexec.mainClass="futuresdemo.SimpleChainedCompletableFutureDemo"

mvn exec:java -Dexec.mainClass="futuresdemo.SimpleParallelCompletableFutureDemo"