[![Build](https://github.com/vrnsky/java-a-to-z/actions/workflows/build.yml/badge.svg?branch=master)](https://github.com/vrnsky/java-a-to-z/actions/workflows/build.yml)
[![codecov](https://codecov.io/gh/vrnsky/java-a-to-z/branch/master/graph/badge.svg)](https://codecov.io/gh/vrnsky/java-a-to-z)
[![Java](https://img.shields.io/badge/Java-17-%23ED8B00.svg?logo=openjdk&logoColor=white)](#)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.5-6DB33F?logo=springboot&logoColor=fff)](#)
[![JUnit5](https://img.shields.io/badge/Tested_with-JUnit_5-1?logo=junit5)](#)
[![Linear](https://img.shields.io/badge/Task_tracker_we_prefer-Linear-5E6AD2?logo=linear&logoColor=fff)](#)

This repository contains solution of task from courses at the job4j.ru course.
In course use next technology :
1. [Maven](https://maven.apache.org/)
2. [JUnit](https://junit.org/junit5/)
3. [Mockito/PowerMock](https://site.mockito.org/)
4. [Hibernate](https://hibernate.org/)
5. [jQuery](https://jquery.com/)
6. [Bootstrap](https://getbootstrap.com/)

Chapters:
1. <strike>[Basic syntax](./chapter1)</strike>
2. <strike>[Object oriented programming](./chapter2)</strike>
3. <strike>[Input/Output](./chapter3)</strike>
4. <strike>[Object oriented design](./chapter4)</strike>
5. <strike>[Collections](./chapter5)</strike>
6. <strike>[Garbage Collector](./chapter6)</strike>
7. <strike>[Multithreading](./chapter7)</strike>
8. <strike>[JDBC](./chapter8)</strike>
9. <strike>[JSP and Servlet](./chapter9)</strike>
10. [Hibenate](./chapter10)
11. [Spring](./chapter11)
12. [Algorithms](./chapter12)
13. [Design Patterns](./chapter13)
14. [Integration](./chapter14)

In project uses checkstyle maven plugin and cobertura for measure coverage.
For continuous integration using [GitHub Actions](https://github.com/features/actions), also for measure coverage use [Сodecov](https://codecov.io).
This project have module based architecture. One lesson - one module. This division made for more comortable work with internal dependencies.

At the second chapter I was build my first java application. It is simple tracker which run in the console and have minimum function such as add new item, edit item and remove, comment item. It runs by the next way:
```
java -jar start-1.0.jar
```

At the chapter №10 I was made similar app to the app, which I made at the second chapter of this course. But now this app have a web interface based on Bootstrap. And instead use JDBC using Hibernate ORM. At the app use Ajax for send request to the server without update the page.

---
Contact: 
[Yegor Voronyansky](https://twitter.com/voronyanskye)