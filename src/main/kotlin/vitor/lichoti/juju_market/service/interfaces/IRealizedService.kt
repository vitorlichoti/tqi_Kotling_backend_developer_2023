package vitor.lichoti.juju_market.service.interfaces

import vitor.lichoti.juju_market.controller.dto.RealizedDto
import vitor.lichoti.juju_market.entity.Cart
import vitor.lichoti.juju_market.entity.Realized

interface IRealizedService {
    fun save(realizedDto: RealizedDto): Realized

    fun findById(id: Int): Realized

    fun findAllSales(): List<Realized>

}