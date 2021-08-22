package com.wookey.study.model

data class StudentMajorResponse(
    val id: Long,
    val name: String,
    val grade: Int,
    val age: Int,
    val major: Int,
    val subject: String,
    val level: Int
)