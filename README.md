Cask
----
>Cask feature tests, to include a model, using uPickle, Requests, Scala-Java-Time, Scalikejdbc, H2 and Scala 3.

Test
----
1. sbt clean test

Run
---
1. sbt run ( new session )
>Multiple main classes detected. Select one to run:
1. objektwerks.Client
2. objektwerks.Server
>Select 2.
2. sbt run ( new session )
>Multiple main classes detected. Select one to run:
1. objektwerks.Client
2. objektwerks.Server
>Select 1.
3. See target/cask.log
4. Close both terminal sessions.

Entity
------
* Pool 1..n ---> 1 Account **
* Pool 1 ---> 1 Surface, Pump, Timer, TimerSetting, Heater, HeaterSetting, Measurement, Cleaning, Chemical, Supply, Repair
* Email 1..n ---> 1 Account **
* Fault
* UoM ( unit of measure )
>** Account contains a globally unique license.

Model
-----
* Server 1 ---> 1 Router
* Router 1 ---> 1 Dispatcher
* Service 1 ---> 1 Store
* Authorizer 1 ---> 1 Service
* Handler 1 ---> 1 Service
* Validator 1 ---> 1 Handler
* Dispatcher 1 ---> 1 Authorizer, Validator
* Client

Sequence
--------
1. Client --- Command ---> Server
2. Server --- Command ---> Router
3. Router --- Command ---> Dispatcher
4. Dispatcher --- Command ---> Authorizer
5. Dispatcher --- Command ---> Validator
6. Dispatcher --- Command ---> Handler
7. Handler --- T ---> Service
8. Service --- T ---> Store --- Email ---> Emailer
9. Service --- Either[Throwable, T] ---> Handler
10. Handler --- Event ---> Dispatcher
11. Dispatcher --- Event ---> Router
12. Router --- Event ---> Server
13. Server --- Event ---> Client

Resources
---------
1. Cask - https://com-lihaoyi.github.io/cask/index.html
2. uPickle - https://com-lihaoyi.github.io/upickle/
3. Requests - https://github.com/com-lihaoyi/requests-scala
4. ScalikeJdbc - http://scalikejdbc.org
5. H2 - https://h2database.com/html/main.html
6. Scala-Java-Time - https://github.com/cquiroz/scala-java-time