package com.scaleablescripts.kotlinsearch.dtos

class PaginatedResponse(
    val data: List<Any>,
    val total: Int,
    val page: Int,
    val lastPage: Int,
) {
}