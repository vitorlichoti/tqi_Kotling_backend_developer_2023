package vitor.lichoti.juju_market.service.interfaces

import vitor.lichoti.juju_market.entity.ProductCart

interface IProductCartService {
    fun save(productCart: ProductCart): ProductCart

    fun findById(id: Int): List<ProductCart>
}