package vitor.lichoti.juju_market.service.interfaces

import vitor.lichoti.juju_market.entity.Cart

interface ICartService {
    fun save(cart: Cart): Cart

    fun findById(id: Long): Cart

    fun delete(id: Long): Cart
}