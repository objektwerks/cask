Cask
----
>Cask feature tests, to include model, using uPickle, Requests, Scala-Java-Time and Scala 3.

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

Model
-----
1. Client --- Command ---> Server
2. Server --- Command ---> Dispatcher
3. Dispatcher --- Command ---> Authorizer
4. Dispatcher --- Command ---> Validator
5. Validator --- Command ---> Handler
6. Handler --- T ---> Service
7. Service --- T ---> Store --- Email ---> Emailer ( via Store.register )
8. Service --- Either[Throwable, T] ---> Handler
9. Handler --- Event ---> Dispatcher
10. Dispatcher --- Event ---> Server
11. Server --- Event ---> Client

Docs
----
1. Cask - https://com-lihaoyi.github.io/cask/index.html
2. uPickle - https://com-lihaoyi.github.io/upickle/
3. Requests - https://github.com/com-lihaoyi/requests-scala