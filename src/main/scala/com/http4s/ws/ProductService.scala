package com.http4s.ws

import com.http4s.persistence.ProductDao
import io.circe.syntax._
import journal.Logger
import org.http4s._
import org.http4s.circe._
import org.http4s.dsl._
import com.http4s.model.Product

object ProductService {

  private val logger = Logger[this.type]

  val productDao = new ProductDao()

  val service = HttpService {
    case GET -> Root / "products" => {
      logger.info(s"GET /products")

      val products = productDao.getProducts()

      Ok(products.asJson)

    }

    case request @ POST -> Root / "products" => {
      logger.info(s"POST /products")

      val productRequest = request.as(jsonOf[Product])

      productRequest.flatMap(product => {
        val insertedProduct = productDao.addProduct(product)
        Ok(insertedProduct.asJson)
      })
    }
  }
}