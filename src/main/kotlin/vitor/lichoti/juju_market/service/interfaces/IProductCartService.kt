package vitor.lichoti.juju_market.service.interfaces

import vitor.lichoti.juju_market.controller.dto.ProductCartDto
import vitor.lichoti.juju_market.entity.ProductCart

interface IProductCartService {
    fun save(productCartDto: ProductCartDto): ProductCart

    fun findById(id: Int): List<ProductCart>
}