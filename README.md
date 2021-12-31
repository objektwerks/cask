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
1. Account
2. Pool 1 ---> 1 Surface, Pump, Timer, TimerSetting, Heater, HeaterSetting, Measurement, Cleaning, Chemical, Supply, Repair
3. Email
4. Fault
5. UoM ( unit of measure )

Model
-----
1. Server 1 ---> 1 Router
2. Router 1 ---> 1 Dispatcher
3. Service 1 ---> 1 Store
4. Authorizer 1 ---> 1 Service
5. Handler 1 ---> 1 Service
6. Validator 1 ---> 1 Handler
7. Dispatcher 1 ---> 1 Authorizer, Validator
8. Client

Sequence
--------
1. Client --- Command ---> Server
2. Server --- Command ---> Router
3. Router --- Command ---> Dispatcher
4. Dispatcher --- Command ---> Authorizer
5. Dispatcher --- Command ---> Validator
6. Validator --- Command ---> Handler
7. Handler --- T ---> Service
8. Service --- T ---> Store --- Email ---> Emailer ( via Store.register )
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