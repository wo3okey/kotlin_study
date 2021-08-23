package com.wookey.study.entity

import javax.persistence.*

@Entity
@Table(name = "pay_book")
data class PayBook(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val bookName: String,
    val price: Long,

    @Column(name="buy_std")
    val buyStd: Long,
    val subject: String
)