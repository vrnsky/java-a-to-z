[![Build Status](https://travis-ci.org/vrnsky/java-a-to-z.svg?branch=master)](https://travis-ci.org/vrnsky/java-a-to-z)
[![Coverage Status](https://coveralls.io/repos/github/vrnsky/java-a-to-z/badge.svg?branch=master)](https://coveralls.io/github/vrnsky/java-a-to-z?branch=master)
# java-a-to-z
This repository contains solution of task from courses at the job4j.ru course.
In course use next technology :
1. Maven
2. JUnit
3. Mockito/PowerMock
4. Hibernate
5. jQuery
6. Bootstrap
<strike>
	<b>
    Chapter1. Basic Syntax
    Chapter2. OOP
    Chapter3. Input/Output
    Chapter4. OOD
    Chapter5. Collections
    Chapter6. Garbage collector
    Chapter7. Multithreading
    Chapter8. JDBC
    Chapter9. JSP/Servlets
    </b>
</strike>
<b>
    Chapter10. Hibernate
    Chapter11. Spring
    Chapter12. Algorithms
    Chapter13. Design Pattern
    Chapter14. Integration
</b>

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