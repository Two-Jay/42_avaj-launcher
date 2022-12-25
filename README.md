# 42_avaj-launcher

A simple aircraft simulator for learning Java. 

***

## 0. Installation
***

Enter the command below in the terminal to run this program. When entered, the current path must be the root directory of the project.


```shell
make
```

The following commands are also supported:
```shell
find * -name "*.java" > sources.txt
javac @sources.txt
java kr.ft.avaj.simulator.Simulator ./example/senario.txt
```

## 1. Description
***

This project is a simple simulation. Depending on the weather in the generated field, it simulates the aircraft present on the field and outputs a message informing them of their condition.

There are three types of aircraft: JetPlane, Helicopter, and Baloon, and the three types of behavior patterns are different.

The example folder contains a scenario file created as an example. Additional modifications can be made there.

## 2. Simulation Input
***
The simulation input shall comply with the following specifications:

- The first line must contain only one positive integer. This number determines how many turns the simulation takes place.

- From the second line, the coordinates, type, and name of the aircraft are recorded.

- Information about the aircraft must be recorded in accordance with the form below.
```
TYPE NAME LONGITUDE LATITUDE HEIGHT
```

- Information about the aircraft is only available on one line.

- There are three types of aircraft. JetPlane, Helicopter, Baloon.

- The aircraft coordinates consist of three values: longitude, latitude, and height.

- The values for longitude, latitude, and height must be positive integers. and the longitude and latitude shall not exceed 300 and height shall not exceed 100.
