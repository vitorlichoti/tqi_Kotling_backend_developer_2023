package vitor.lichoti.juju_market.controller

import org.springframework.web.bind.annotation.*
import vitor.lichoti.juju_market.controller.dto.RealizedDto
import vitor.lichoti.juju_market.entity.Realized
import vitor.lichoti.juju_market.service.ProductCartService
import vitor.lichoti.juju_market.service.RealizedService

@RestController
@RequestMapping("/api/checkout")
class RealizedController(
    private val realizedService: RealizedService
) {
    @PostMapping
    fun saveRealizedSale(@RequestBody realizedDto: RealizedDto): String {
        val savedRealizedSale = this.realizedService.save(realizedDto)

        return "Thanks for buy with us, Payment Type: ${savedRealizedSale.typePayment}, Amount: ${savedRealizedSale.totalPrice}"
    }

    @GetMapping
    fun findAll(): List<Realized> {
        return this.realizedService.findAllSales()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): Realized {
        return this.realizedService.findById(id)
    }
}