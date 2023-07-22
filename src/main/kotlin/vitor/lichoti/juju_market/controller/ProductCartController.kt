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
    private val productCartService: ProductCartService,
    private val productService: ProductService,
    private val cartService: CartService
) {
    @PostMapping
    fun saveProductCart(@RequestBody productCartDto: ProductCartDto): String {
        if (productCartDto.cartId == null) {
            val cart = Cart(
                status = 0
            )

            val savedCart: Cart = this.cartService.save(cart)

            val product: Product = this.productService.findById(productCartDto.productId)

            val subTotal = product.unitPrice * productCartDto.amount

            val productCart = ProductCart(
                product = product,
                cart = savedCart,
                amount = productCartDto.amount,
                salePrice = subTotal
            )
            this.productCartService.save(productCart)

            return "Product add in cart"
        }

        val product:Product = this.productService.findById(productCartDto.productId)

        val cart: Cart = this.cartService.findById(productCartDto.cartId)

        val subTotal = product.unitPrice * productCartDto.amount

        val productCart = ProductCart(
            product = product,
            cart = cart,
            amount = productCartDto.amount,
            salePrice = subTotal
        )

        this.productCartService.save(productCart)

        return "Product add in cart"
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): List<ProductCart> {
         return this.productCartService.findById(id)
    }
}