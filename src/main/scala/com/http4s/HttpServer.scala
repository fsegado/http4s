package com.http4s

import com.http4s.ws.ProductService
import com.typesafe.config.ConfigFactory
import fs2.{Stream, Task}
import journal.Logger
import org.http4s.server.blaze.BlazeBuilder
import org.http4s.util.StreamApp

object HttpServer extends StreamApp {

  private val logger = Logger[this.type]

  private val WebServerNameKey = "webServer.name"
  private val WebServerPortKey = "webServer.port"

  override def stream(args: List[String]): Stream[Task, Nothing] = {

    val config = ConfigFactory.load()

    val name = config.getString(WebServerNameKey)
    val port = config.getInt(WebServerPortKey)

    logger.info(s"Starting server: $name:$port...")

    BlazeBuilder
      .bindHttp(8081, "localhost")
      .mountService(ProductService.service)
      .serve
  }
}