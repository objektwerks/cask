Cask
----
>Cask feature tests, to include a model, client and server using uPickle, Requests, Scalatags, Scala-Java-Time, Scalikejdbc, H2, Scaffeine and Scala 3.

Test
----
1. sbt clean test

Run
---
* sbt run
>Multiple main classes detected. Select one to run:
1. objektwerks.Client
2. objektwerks.ResourceServer
3. objektwerks.Server
4. objektwerks.WebServer

>To run Server and Client:
1. sbt run ( new session )
2. select 3
3. sbt run ( new session )
4. select 1
5. view client result
6. close both terminal sessions.
7. see target/cask.log

>To run ResourceServer:
1. sbt run
2. select 2
3. open browser to: http://localhost:7070/
4. press **return key** to stop server.
5. see target/cask.log

>To run WebServer:
1. sbt run
2. select 4
3. open browser to: http://localhost:7171/scalatags
4. press **return key** to stop server.
5. see target/cask.log

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
> See router.Resources and router.ResourcesRouter for an approach to loading:
1. index.html at /base-path/index.html
2. web resources at /base-path/

Logs
----
>See logs at target/
1. cask.log
2. test.log

Documentation
-------------
1. Cask - https://com-lihaoyi.github.io/cask/index.html
2. uPickle - https://com-lihaoyi.github.io/upickle/
3. Requests - https://github.com/com-lihaoyi/requests-scala
4. ScalikeJdbc - http://scalikejdbc.org
5. H2 - https://h2database.com/html/main.html
6. Scala-Java-Time - https://github.com/cquiroz/scala-java-time
7. Scalatags - https://com-lihaoyi.github.io/scalatags/#ScalaTags
8. Scaffiene - https://github.com/blemale/scaffeine
