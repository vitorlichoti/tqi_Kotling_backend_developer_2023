package vitor.lichoti.juju_market.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
data class Cart(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(nullable = false)
    @OneToMany(mappedBy = "cart")
    @JsonIgnore
    val productCart: List<ProductCart> = mutableListOf(),

    @Column(nullable = false)
    val status: Byte
)
