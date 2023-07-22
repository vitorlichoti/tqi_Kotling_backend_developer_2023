package vitor.lichoti.juju_market.controller.dto

import vitor.lichoti.juju_market.entity.Cart
import vitor.lichoti.juju_market.entity.Product
import vitor.lichoti.juju_market.entity.ProductCart

data class ProductCartDto(
    val productId: Long,
    val cartId: Long?,
    val amount: Int
)
