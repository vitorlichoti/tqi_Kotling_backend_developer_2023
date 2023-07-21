package vitor.lichoti.juju_market.service.interfaces

import vitor.lichoti.juju_market.entity.Product

interface IProductService {
    fun save(product: Product): Product

    fun findById(id: Long): Product

    fun delete(id: Long)
}