[![Build Status](https://travis-ci.org/vrnsky/java-a-to-z.svg?branch=master)](https://travis-ci.org/vrnsky/java-a-to-z)
[![codecov](https://codecov.io/gh/vrnsky/java-a-to-z/branch/master/graph/badge.svg)](https://codecov.io/gh/vrnsky/java-a-to-z)
This repository contains solution of task from courses at the job4j.ru course.
In course use next technology :
1. Maven
2. JUnit
3. Mockito/PowerMock
4. Hibernate
5. jQuery
6. Bootstrap

Chapters:
1. <strike>Basic syntax</strike>
2. <strike>Object oriented programming</strike>
3. <strike>Input/Output</strike>
4. <strike>Object oriented design</strike>
5. <strike>Collections</strike>
6. <strike>Garbage Collector.</strike>
7. <strike>Multithreading</strike>
8. <strike>JDBC</strike>
9. <strike>JSP and Servlet</strike>
10. Hibenate
11. Spring
12. Algorithms
13. Design Patterns
14. Integration

In project uses checkstyle maven plugin and cobertura for measure coverage.
For continious integration using [Travis CI](https://travis-ci.org), also for measure coverage use [Coveralls](https://coveralls.io).
This project have module based architecture. One lesson - one module. This division made for more comortable work with internal dependencies.

At the second chapter I was build my first java application. It is simple tracker which run in the console and have minimum function such as add new item, edit item and remove, comment item. It runs by the next way:
```
java -jar start-1.0.jar
```

At the chapter №10 I was made similar app to the app, which I made at the second chapter of this course. But now this app have a web interface based on Bootstrap. And instead use JDBC using Hibernate ORM. At the app use Ajax for send request to the server without update the page.

---
Contact: [Yegor Voronyansky](https://twitter.com/voronyanskye)