package vitor.lichoti.juju_market.service

import org.springframework.stereotype.Service
import vitor.lichoti.juju_market.controller.dto.ProductCartDto
import vitor.lichoti.juju_market.entity.Cart
import vitor.lichoti.juju_market.entity.Product
import vitor.lichoti.juju_market.entity.ProductCart
import vitor.lichoti.juju_market.repository.ProductCartRepository
import vitor.lichoti.juju_market.service.interfaces.IProductCartService

@Service
class ProductCartService(
    private val productCartRepository: ProductCartRepository,
    private val productService: ProductService,
    private val cartService: CartService
): IProductCartService {
    override fun save(productCartDto: ProductCartDto): ProductCart {
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
            return this.productCartRepository.save(productCart)
        }

        val product: Product = this.productService.findById(productCartDto.productId)

        val cart: Cart = this.cartService.findById(productCartDto.cartId)

        val subTotal = product.unitPrice * productCartDto.amount

        val productCart = ProductCart(
            product = product,
            cart = cart,
            amount = productCartDto.amount,
            salePrice = subTotal
        )

        this.productCartRepository.save(productCart)


        return this.productCartRepository.save(productCart)
    }

    override fun findById(id: Int): List<ProductCart> {
        return this.productCartRepository.findAll().filter { e -> id == e.cart.id}
    }

}