package vitor.lichoti.juju_market.service

import org.springframework.stereotype.Service
import vitor.lichoti.juju_market.entity.Realized
import vitor.lichoti.juju_market.repository.RealizedRepository
import vitor.lichoti.juju_market.service.interfaces.IRealizedService

@Service
class RealizedService(
    private val realizedRepository: RealizedRepository
): IRealizedService {
    override fun save(realized: Realized): Realized {
        return this.realizedRepository.save(realized)
    }

    override fun findById(id: Long): Realized {
        return this.realizedRepository.findById(id).orElseThrow{
            throw RuntimeException("Id $id not found")
        }
    }

    override fun findAllSales(): List<Realized> {
        return this.realizedRepository.findAll()
    }
}