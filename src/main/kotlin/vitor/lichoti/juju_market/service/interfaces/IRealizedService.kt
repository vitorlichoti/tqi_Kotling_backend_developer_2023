package vitor.lichoti.juju_market.service.interfaces

import vitor.lichoti.juju_market.entity.Cart
import vitor.lichoti.juju_market.entity.Realized

interface IRealizedService {
    fun save(realized: Realized): Realized

    fun findById(id: Long): Realized

    fun findAllSales(): List<Realized>

}