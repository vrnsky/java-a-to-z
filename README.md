[![Build](https://github.com/vrnsky/java-a-to-z/actions/workflows/build.yml/badge.svg?branch=master)](https://github.com/vrnsky/java-a-to-z/actions/workflows/build.yml)
[![codecov](https://codecov.io/gh/vrnsky/java-a-to-z/branch/master/graph/badge.svg)](https://codecov.io/gh/vrnsky/java-a-to-z)
[![Java](https://img.shields.io/badge/Java-17-%23ED8B00.svg?logo=openjdk&logoColor=white)](#)
[![JUnit5](https://img.shields.io/badge/Tested_with-JUnit_5-1?logo=junit5)](#)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=vrnsky_java-a-to-z&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=vrnsky_java-a-to-z)

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

In the project, we use Checkstyle Maven plugin to prevent malformed code and JaCoCo Maven plugin
for measuring coverage. For continuous integration using [GitHub Actions](https://github.com/features/actions),
we also use [CodeCov](https://codecov.io) for measuring coverage. In the recent updates, we have introduced mutation testing with the PIT Maven plugin.

The project has a module-based architecture. 
One lesson - one module. We made this division for more comfortable work with internal dependencies.

At the second chapter, we built our first Java application. It is a simple console task tracker.
It has minimal functions: adding, editing, and removing or commenting on an item. It runs
by the following way
```
java -jar start-1.0.jar
```

In chapter 10, I created a similar app to the one I made in the second chapter of 
this course. But now this app has a web interface based on Bootstrap. Instead
of using JDBC, I am using Hibernate ORM. In the app, I use Ajax to send requests 
to the server without updating the page.


---
Contacts:

[![Medium](https://img.shields.io/badge/Medium-%23000000.svg?logo=medium&logoColor=white)](https://vrnsky.medium.com)
[![Substack](https://img.shields.io/badge/Substack-FF6719?logo=substack&logoColor=fff)](https://vrnsky.substack.com)
[![GitHub Pages](https://img.shields.io/badge/GitHub%20Pages-121013?logo=github&logoColor=white)](https://vrnsky.github.io)
[![Mastodon](https://img.shields.io/badge/Mastodon-6364FF?logo=mastodon&logoColor=fff)](https://me.dm/@vrnsky)
