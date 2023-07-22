package vitor.lichoti.juju_market.service

import org.springframework.stereotype.Service
import vitor.lichoti.juju_market.entity.ProductCart
import vitor.lichoti.juju_market.repository.ProductCartRepository
import vitor.lichoti.juju_market.service.interfaces.IProductCartService

@Service
class ProductCartService(
    private val productCartRepository: ProductCartRepository
): IProductCartService {
    override fun save(productCart: ProductCart): ProductCart {
        return this.productCartRepository.save(productCart)
    }

    override fun findById(id: Int): List<ProductCart> {
        return this.productCartRepository.findAll().filter { e -> id == e.cart.id}
    }

}