package vitor.lichoti.juju_market.service

import org.springframework.stereotype.Service
import vitor.lichoti.juju_market.entity.Cart
import vitor.lichoti.juju_market.service.interfaces.ICartService

@Service
class CartService: ICartService {
    override fun save(cart: Cart): Cart {
        TODO("Not yet implemented")
    }

    override fun findById(id: Long): Cart {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long): Cart {
        TODO("Not yet implemented")
    }
}