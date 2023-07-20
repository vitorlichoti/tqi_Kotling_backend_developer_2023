package vitor.lichoti.juju_market.entity

import jakarta.persistence.*

@Entity
data class Cart(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(nullable = false)
    @OneToMany(mappedBy = "cart")
    val productCart: List<ProductCart> = mutableListOf()
)
