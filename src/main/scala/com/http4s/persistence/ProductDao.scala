package com.http4s.persistence;

import com.http4s.model.Product

import scala.util.Random;

class ProductDao {

    var products = Seq(Product(1, "Acqua di Gio", "Giorgio Armani", 42.95), Product(2, "Versace Eros", "Versace", 49.95))

    def getProducts(): Seq[Product] = {
        Thread.sleep(Random.nextInt(100))
        products
    }

    def addProduct(product: Product): Product = {
        Thread.sleep(Random.nextInt(100))
        products = products :+ product
        product
    }
}
