package vitor.lichoti.juju_market.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*


@Entity
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(nullable = false)
    val productName: String,

    @Column(nullable = false)
    val measurement: String,

    @Column(nullable = false)
    val unitPrice: Float,

    @ManyToOne
    val category: Category,

    @Column(nullable = false)
    @OneToMany(mappedBy = "product")
    @JsonIgnore
    val productCart: List<ProductCart> = mutableListOf()
)
