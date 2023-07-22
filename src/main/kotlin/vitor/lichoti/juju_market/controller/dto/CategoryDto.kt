package vitor.lichoti.juju_market.controller.dto

import vitor.lichoti.juju_market.entity.Category

data class CategoryDto(
    val categoryName: String
) {
    fun toEntity(): Category = Category(
        categoryName = this.categoryName
    )
}
