package com.scaleablescripts.kotlinsearch.controllers

import com.scaleablescripts.kotlinsearch.dtos.PaginatedResponse
import com.scaleablescripts.kotlinsearch.models.Product
import com.scaleablescripts.kotlinsearch.repositories.ProductRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ProductController(
    private val productRepository: ProductRepository
) {

    @GetMapping("/products/frontend")
    fun frontend(): ResponseEntity<List<Product>> = ResponseEntity.ok(this.productRepository.findAll())

    @GetMapping("/products/backend")
    fun backend(
        @RequestParam("s", defaultValue = "") s: String,
        @RequestParam("sort", defaultValue = "") sort: String,
        @RequestParam("page", defaultValue = "") page: Int,
    ): ResponseEntity<PaginatedResponse> {
        var direction = Sort.unsorted()

        if (sort == "asc") {
            direction = Sort.by(Sort.Direction.ASC, "price")
        } else if (sort == "desc") {
            direction = Sort.by(Sort.Direction.DESC, "price")
        }

        val perPage = 9
        val total = this.productRepository.countSearch(s)

        return ResponseEntity.ok(
            PaginatedResponse(
                data = this.productRepository.search(s, PageRequest.of(page - 1, perPage, direction)),
                total,
                page,
                lastPage = total/perPage
            )
        )
    }
}