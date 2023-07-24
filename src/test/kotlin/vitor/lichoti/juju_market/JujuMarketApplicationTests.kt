package vitor.lichoti.juju_market

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.springframework.boot.test.context.SpringBootTest
import vitor.lichoti.juju_market.controller.dto.ProductCartDto
import vitor.lichoti.juju_market.entity.Cart
import vitor.lichoti.juju_market.entity.Category
import vitor.lichoti.juju_market.entity.Product
import vitor.lichoti.juju_market.entity.ProductCart
import vitor.lichoti.juju_market.repository.ProductCartRepository
import vitor.lichoti.juju_market.service.CartService
import vitor.lichoti.juju_market.service.CategoryService
import vitor.lichoti.juju_market.service.ProductCartService
import vitor.lichoti.juju_market.service.ProductService

@SpringBootTest
class JujuMarketApplicationTests {

    @Mock
    private lateinit var productCartRepository: ProductCartRepository

    @Mock
    private lateinit var productService: ProductService

    @Mock
    private lateinit var categoryService: CategoryService

    @Mock
    private lateinit var cartService: CartService

    @InjectMocks
    private lateinit var productCartService: ProductCartService

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun createCartIfNew() {
        val amount = 2
        val savedCategory = categoryService.save(Category(categoryName = "Bebidas"))
        val savedProduct = productService.save(Product(productName = "Heineken", measurement = "290ml", unitPrice = 4.75f, category = savedCategory))
        val product = Product(id = savedProduct.id, productName = savedProduct.productName, category = savedProduct.category, unitPrice = savedProduct.unitPrice, measurement = savedProduct.measurement)
        val savedCart = Cart(id = 1, status = 0)
        val productCartDto = savedCart.id?.let { ProductCartDto(it.toLong(), savedProduct.id?.toLong(), amount) }
        val subTotal = product.unitPrice * amount
        val expectedProductCart = ProductCart(amount = amount, product = savedProduct, cart = savedCart, salePrice = subTotal)

        // Mock dependencies' behavior
        `when`(cartService.save(Cart(status = 0))).thenReturn(savedCart)
        `when`(savedProduct.id?.let { productService.findById(it.toLong()) }).thenReturn(product)
        `when`(productCartRepository.save(expectedProductCart)).thenReturn(expectedProductCart)

        // Call the method to be tested
        val result = productCartDto?.let { productCartService.save(it) }

        // Verify the result
        assertNotNull(result)
        assertEquals(expectedProductCart, result)

        // Verify the interactions with mock objects
        verify(cartService, times(1)).save(Cart(status = 0))
        savedProduct.id?.let { verify(productService, times(1)).findById(it.toLong()) }
        verify(productCartRepository, times(1)).save(expectedProductCart)
    }

}
