package vitor.lichoti.juju_market.controller.dto

import vitor.lichoti.juju_market.entity.Cart

data class CartDto(
    val status:Byte
) {
    fun toEntity(): Cart = Cart(
        status = this.status
    )
}
