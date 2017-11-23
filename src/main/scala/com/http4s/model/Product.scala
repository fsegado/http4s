package com.http4s.model

import io.circe.{Decoder, Encoder}
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}

final case class Product(id: Long, name: String, brand: String, price: Double)

object Product {
  implicit val productEncoder: Encoder[Product] = deriveEncoder
  implicit val productDecoder: Decoder[Product] = deriveDecoder
}
