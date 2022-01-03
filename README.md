Cask
----
>Cask feature tests, to include a model, client and server using uPickle, Requests, Scala-Java-Time, Scalikejdbc, H2 and Scala 3.
>A web server, using Scalatags, is also included.

Test
----
1. sbt clean test

Run
---
>To run Server and Client:
1. sbt run ( new session )
>Multiple main classes detected. Select one to run:
1. objektwerks.Client
2. objektwerks.Server
3. objektwerks.WebServer
>Select 2.
2. sbt run ( new session )
>Multiple main classes detected. Select one to run:
1. objektwerks.Client
2. objektwerks.Server
3. objektwerks.WebServer
>Select 1.
3. See target/cask.log
4. Close both terminal sessions.
>To run WebServer ( http://localhost:7070/ ):
1. objektwerks.Client
2. objektwerks.Server
3. objektwerks.WebServer
>Select 3.

Entity
------
* Pool 1..n ---> 1 Account **
* Pool 1 ---> 1..n Surface, Pump, Timer, TimerSetting, Heater, HeaterSetting, Measurement, Cleaning, Chemical, Supply, Repair
* Email 1..n ---> 1 Account **
* Fault
* UoM ( unit of measure )
>** Account contains a globally unique license.

Model
-----
* Server 1 ---> 1 Router 1 ---> 1 Dispatcher
* Service 1 ---> 1 Store 1 ---> 1 Emailer
* Authorizer, Handler 1 ---> 1 Service
* Dispatcher 1 ---> 1 Authorizer, Validator, Handler
* Client

Sequence
--------
1. Client --- Command ---> Server
2. Server --- Command ---> Router
3. Router --- Command ---> Dispatcher
4. Dispatcher --- Command ---> Authorizer, Validator, Handler
5. Handler --- T ---> Service
6. Service --- T ---> Store --- Email ---> Emailer
7. Service --- Either[Throwable, T] ---> Handler
8. Handler --- Event ---> Dispatcher
9. Dispatcher --- Event ---> Router
10. Router --- Event ---> Server
11. Server --- Event ---> Client

Resources
---------
1. Cask - https://com-lihaoyi.github.io/cask/index.html
2. uPickle - https://com-lihaoyi.github.io/upickle/
3. Requests - https://github.com/com-lihaoyi/requests-scala
4. ScalikeJdbc - http://scalikejdbc.org
5. H2 - https://h2database.com/html/main.html
6. Scala-Java-Time - https://github.com/cquiroz/scala-java-time
7. Scalatags - https://com-lihaoyi.github.io/scalatags/#ScalaTags