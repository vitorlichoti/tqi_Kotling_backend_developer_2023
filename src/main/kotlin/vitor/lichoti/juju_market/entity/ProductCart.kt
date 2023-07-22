package vitor.lichoti.juju_market.entity

import jakarta.persistence.*

@Entity
data class ProductCart(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @ManyToOne
    @JoinColumn(name = "product_id")
    val product: Product,

    @ManyToOne
    @JoinColumn(name = "cart_id")
    val cart: Cart,

    @Column(nullable = false)
    val amount: Int,

    @Column(nullable = false)
    val salePrice: Float
)
