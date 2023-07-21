package vitor.lichoti.juju_market.service

import org.springframework.stereotype.Service
import vitor.lichoti.juju_market.entity.Category
import vitor.lichoti.juju_market.repository.CategoryRepository
import vitor.lichoti.juju_market.service.interfaces.ICategoryService

@Service
class CategoryService(
    private val categoryRepository: CategoryRepository
): ICategoryService {
    override fun save(category: Category): Category {
        return this.categoryRepository.save(category)
    }

    override fun findById(id: Long): Category {
        return this.categoryRepository.findById(id).orElseThrow{
            throw RuntimeException("Id $id not found")
        }
    }

    override fun delete(id: Long) = this.categoryRepository.deleteById(id)
}