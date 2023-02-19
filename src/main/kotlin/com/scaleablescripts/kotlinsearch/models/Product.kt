package com.scaleablescripts.kotlinsearch.models

import org.springframework.data.mongodb.core.mapping.Document

@Document
class Product (
    var id: String = "",
    var title: String = "",
    var description: String = "",
    var image: String = "",
    var price: Double = 0.00
) {
}