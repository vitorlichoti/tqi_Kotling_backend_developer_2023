package vitor.lichoti.juju_market.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import vitor.lichoti.juju_market.controller.dto.ProductDto
import vitor.lichoti.juju_market.entity.Product
import vitor.lichoti.juju_market.service.ProductService

@RestController
@RequestMapping("/api/products")
class ProductController(
    private val productService: ProductService
) {
    @GetMapping
    fun getProducts(): List<Product> {
        return this.productService.findAll()
    }

    @PostMapping
    fun saveProduct(@RequestBody productDto: ProductDto): String {
        val savedProduct = this.productService.save(productDto.toEntity())
        return "Product $savedProduct is saved"
    }
}