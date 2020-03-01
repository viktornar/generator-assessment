
Genarator-assessment
===================
A simple console application for counting how many numbers in generator matches


The main technologies (frameworks, build tools) that was used in project
-------------
- Standard Java API (that comes with Java 1.11 JDK)
- Apache common Lang 3 for simplifying some stuff
- JUnit for testing
- Maven > 3.0 for project build is needed

> **Note:**
> - Project was written by using Java SDK 1.11. Source was compiled without compatibility with older Java version. So you need to have java 1.11 SDK to run this app.

How to build and run project
-------------
Clone the project with the following command:

``
TO BE DONE
``

Go to the project directory:

```bash
$ cd generator-assessment
```

and run:

```bash
mvn clean package assembly:single
```

During compile and package process test will be executed. If everything will be ok you will have a binary to run app.

To execute program run:

```bash
java -jar target/generator-assessment-jar-with-dependencies.jar --first-number 65 --second-number 8291
```

> **Note:**
> - You can also use already compiled jar for demo in bin directory.

```bash
java -jar bin/generator-assessment.jar --first-number 65 --second-number 8291
```

How to develop project
-------------
If you use IDEA or Eclipse just import project as maven project. In IDEA use mvn wrapper. 