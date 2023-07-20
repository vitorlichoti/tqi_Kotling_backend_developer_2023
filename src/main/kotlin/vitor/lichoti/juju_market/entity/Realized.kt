package vitor.lichoti.juju_market.entity

import jakarta.persistence.*
import vitor.lichoti.juju_market.enummerations.Payment

@Entity
data class Realized(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(nullable = false)
    val typePayment: Payment,

    @Column(nullable = false)
    val totalPrice: Float,
)
