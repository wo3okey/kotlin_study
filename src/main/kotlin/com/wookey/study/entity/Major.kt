package com.wookey.study.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Major(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val subject: String,
    val level: Int
) {
    companion object {
        fun defaultMajor(): Major {
            return Major(0, "notting", 0)
        }
    }
}