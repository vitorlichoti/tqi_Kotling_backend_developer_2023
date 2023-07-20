package vitor.lichoti.juju_market.repository

import org.springframework.data.jpa.repository.JpaRepository
import vitor.lichoti.juju_market.entity.ProductCart

interface ProductCartRepository: JpaRepository<ProductCart, Long> {
}