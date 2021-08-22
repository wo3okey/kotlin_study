package com.wookey.study.repository

import com.querydsl.core.Tuple
import com.querydsl.jpa.impl.JPAQueryFactory
import com.wookey.study.entity.QMajor
import com.wookey.study.entity.QStudent
import com.wookey.study.entity.Student
import org.springframework.stereotype.Repository

@Repository
class StudentRepository(
    private val jpaQueryFactory: JPAQueryFactory
) {
    private val student: QStudent = QStudent.student
    private val major: QMajor = QMajor.major

    fun selectAllStudent(): List<Student> {
        return jpaQueryFactory
            .selectFrom(student)
            .fetch()
    }

    fun selectStudentByName(name: String): Student? {
        return jpaQueryFactory
            .selectFrom(student)
            .where(student.name.eq(name))
            .fetchOne()
    }

    fun selectStudentMajorByMajorLevel(level: Int): List<Any> {
        return jpaQueryFactory
            .select(student)
            .from(student)
            .innerJoin(student.major, major)
            .where(major.level.eq(level))
            .fetch()
    }
}