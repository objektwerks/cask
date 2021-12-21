Cask
----
>Cask feature tests, to include model, using uPickle, Requests, Scala-Java-Time and Scala 3.

Test
----
1. sbt clean test

Run
---
1. sbt run

Model
-----
1. Client --- Command ---> Dispatcher
2. Dispatcher --- Command ---> Authorizer
3. Dispatcher --- Command ---> Validator
4. Validator --- Command ---> Handler
5. Handler --- T ---> Service
6. Service --- T ---> Store --- Email ---> Emailer ( via Store.register )
7. Service --- Either[Throwable, T] ---> Handler
8. Handler --- Event ---> Dispatcher
9. Dispatcher --- Event ---> Client

Docs
----
1. Cask - https://com-lihaoyi.github.io/cask/#todomvc-full-stack-web