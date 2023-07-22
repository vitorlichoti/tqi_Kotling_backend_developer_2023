package vitor.lichoti.juju_market.service

import org.springframework.stereotype.Service
import vitor.lichoti.juju_market.entity.Cart
import vitor.lichoti.juju_market.repository.CartRepository
import vitor.lichoti.juju_market.service.interfaces.ICartService

@Service
class CartService(
    private val cartRepository: CartRepository
): ICartService {
    override fun save(cart: Cart): Cart {
        return this.cartRepository.save(cart)
    }

    override fun findById(id: Long): Cart {
        return this.cartRepository.findById(id).orElseThrow{
            throw RuntimeException("Id $id not found")
        }
    }

    override fun findAll(): List<Cart> {
        return this.cartRepository.findAll()
    }

    override fun delete(id: Long): Cart {
        TODO("Not yet implemented")
    }
}