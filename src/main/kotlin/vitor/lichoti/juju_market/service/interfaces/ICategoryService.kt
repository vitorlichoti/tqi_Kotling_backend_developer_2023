package vitor.lichoti.juju_market.service.interfaces

import vitor.lichoti.juju_market.entity.Category

interface ICategoryService {
    fun save(category: Category): Category

    fun findById(id: Long): Category

    fun delete(id: Long)
}