#!/bin/bash -ex

javac -d bin -cp phase1.jar src/cs1302/p2/BaseStringList.java
javac -cp bin:phase1.jar -d bin src/cs1302/p2/ArrayStringList.java
javac -cp bin:phase1.jar -d bin src/cs1302/p2/LinkedStringList.java
StringListTester1 ArrayStringList
StringListTester1 LinkedStringList
