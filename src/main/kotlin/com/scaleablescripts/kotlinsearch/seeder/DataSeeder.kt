package com.scaleablescripts.kotlinsearch.seeder

import com.scaleablescripts.kotlinsearch.models.Product
import com.scaleablescripts.kotlinsearch.repositories.ProductRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import kotlin.random.Random

//@Component
//class DataSeeder(
//    private val productRepository: ProductRepository
//) : ApplicationRunner {
//    override fun run(args: ApplicationArguments?) {
//        for (i in 1..50) {
//            var product = Product()
//            product.title = "Title #$i"
//            product.description = "Description #${ i + 1 }"
//            product.image = "http://lorempixel.com/200/200?${ Random.nextInt(10000)}"
//            product.price = Random.nextDouble(10.00, 100.00)
//            this.productRepository.save(product)
//        }
//    }
//}