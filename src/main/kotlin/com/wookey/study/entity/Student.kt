package com.wookey.study.entity

import javax.persistence.*

@Entity
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    val grade: Int,
    val age: Int,

    @OneToOne
    @JoinColumn(name="major")
    val major: Major,

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="buy_std")
    val payBookList: List<PayBook>
) {
    companion object {
        fun notFoundStudent(): Student {
            return Student(0, "notfound", 0, 0, Major.defaultMajor(), listOf())
        }
    }
}