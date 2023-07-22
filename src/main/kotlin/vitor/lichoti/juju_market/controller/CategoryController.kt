package vitor.lichoti.juju_market.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import vitor.lichoti.juju_market.controller.dto.CategoryDto
import vitor.lichoti.juju_market.entity.Category
import vitor.lichoti.juju_market.service.CategoryService

@RestController
@RequestMapping("/api/categories")
class CategoryController(
    private val categoryService: CategoryService
) {
    @PostMapping
    fun saveCategory(@RequestBody categoryDto: CategoryDto): String {
        val savedCategory = this.categoryService.save(categoryDto.toEntity())
        return "Category '${savedCategory.categoryName}' is saved"
    }

    @GetMapping
    fun getAllCategories(): List<Category> {
        return this.categoryService.findAll()
    }
}