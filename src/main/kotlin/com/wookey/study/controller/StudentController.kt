package com.wookey.study.controller

import com.wookey.study.entity.Student
import com.wookey.study.service.StudentService
import org.apache.logging.log4j.util.Strings
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class StudentController(private val studentService: StudentService) {
    @GetMapping("/all")
    fun getAllStudents(): List<Student> {
        return studentService.getAllStudents()
    }

    @GetMapping("/name")
    fun getStudentByName(@RequestParam(value = "name", defaultValue = Strings.EMPTY) name: String): Student {
        return studentService.getStudentByName(name)
    }
}