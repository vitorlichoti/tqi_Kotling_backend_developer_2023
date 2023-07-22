package vitor.lichoti.juju_market.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import vitor.lichoti.juju_market.controller.dto.CartDto
import vitor.lichoti.juju_market.entity.Cart
import vitor.lichoti.juju_market.service.CartService

@RestController
@RequestMapping("/api/cart")
class CartController(
    private val cartService: CartService
) {
    @PostMapping
    fun createCart(@RequestBody cartDto: CartDto): String {
        val createdCart = this.cartService.save(cartDto.toEntity())

        return "Cart ${createdCart.id} created with status ${createdCart.status}"
    }

    @GetMapping
    fun getAllCarts(): List<Cart> {
        return this.cartService.findAll()
    }
}