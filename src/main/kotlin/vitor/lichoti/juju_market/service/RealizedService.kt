package vitor.lichoti.juju_market.service

import org.springframework.stereotype.Service
import vitor.lichoti.juju_market.controller.dto.RealizedDto
import vitor.lichoti.juju_market.entity.Realized
import vitor.lichoti.juju_market.enummerations.Payment
import vitor.lichoti.juju_market.repository.RealizedRepository
import vitor.lichoti.juju_market.service.interfaces.IRealizedService

@Service
class RealizedService(
    private val realizedRepository: RealizedRepository,
    private val productCartService: ProductCartService
): IRealizedService {
    override fun save(realizedDto: RealizedDto): Realized {
        val itemsToCheckout = this.productCartService.findById(realizedDto.cartId)

        val totalPrice = itemsToCheckout.map { it.salePrice * it.amount }.sum()

        val realized = Realized(
            totalPrice = totalPrice,
            typePayment = Payment.valueOf(realizedDto.typePayment.uppercase())
        )

        return this.realizedRepository.save(realized)
    }

    override fun findById(id: Int): Realized {
        return this.realizedRepository.findById(id.toLong()).orElseThrow{
            throw RuntimeException("Id $id not found")
        }
    }

    override fun findAllSales(): List<Realized> {
        return this.realizedRepository.findAll()
    }
}