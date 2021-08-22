package com.wookey.study.service

import com.wookey.study.entity.Student
import com.wookey.study.repository.StudentRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class StudentService(
    private val studentRepository: StudentRepository
) {
    fun getAllStudents(): List<Student> {
        return studentRepository.selectAllStudent()
    }

    fun getStudentByName(name: String): Student {
        return Optional
            .ofNullable(studentRepository.selectStudentByName(name))
            .orElse(Student.notFoundStudent())
    }
}