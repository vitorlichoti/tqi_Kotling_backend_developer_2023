package vitor.lichoti.juju_market.controller.dto

import vitor.lichoti.juju_market.entity.Category
import vitor.lichoti.juju_market.entity.Product

data class ProductDto(
    val productName: String,
    val measurement: String,
    val unitPrice: Float,
    val category: Category
) {
    fun toEntity(): Product = Product(
        productName = this.productName,
        measurement = this.measurement,
        unitPrice = this.unitPrice,
        category = this.category
    )
}
