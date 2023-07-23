package vitor.lichoti.juju_market.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import vitor.lichoti.juju_market.controller.dto.ProductCartDto
import vitor.lichoti.juju_market.entity.Cart
import vitor.lichoti.juju_market.entity.Product
import vitor.lichoti.juju_market.entity.ProductCart
import vitor.lichoti.juju_market.service.CartService
import vitor.lichoti.juju_market.service.ProductCartService
import vitor.lichoti.juju_market.service.ProductService

@RestController @RequestMapping("/api/cart-products") class ProductCartController(
    private val productCartService: ProductCartService
) {
    @PostMapping
    fun saveProductCart(@RequestBody productCartDto: ProductCartDto): String {
        this.productCartService.save(productCartDto)
        return "Product add in cart"
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): List<ProductCart> {
         return this.productCartService.findById(id)
    }
}