package com.http4s.persistence;

import com.http4s.model.Product;

class ProductDao {

    var products = Seq(Product(1, "Acqua di Gio", "Giorgio Armani", 42.95), Product(2, "Versace Eros", "Versace", 49.95))

    def getProducts(): Seq[Product] = {
        products
    }

    def addProduct(product: Product): Product = {
        products = products :+ product
        product
    }
}
