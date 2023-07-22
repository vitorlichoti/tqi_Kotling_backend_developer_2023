package vitor.lichoti.juju_market.service

import org.springframework.stereotype.Service
import vitor.lichoti.juju_market.entity.Product
import vitor.lichoti.juju_market.repository.ProductRepository
import vitor.lichoti.juju_market.service.interfaces.IProductService

@Service
class ProductService(
    private val productRepository: ProductRepository
): IProductService {
    override fun save(product: Product): Product {
        return this.productRepository.save(product)
    }

    override fun findById(id: Long): Product {
        return this.productRepository.findById(id).orElseThrow{
            throw RuntimeException("Product Id $id not found")
        }
    }

    override fun findAll(): List<Product> {
        return this.productRepository.findAll()
    }

    override fun delete(id: Long) {
        this.productRepository.deleteById(id)
    }
}