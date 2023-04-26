package com.alarcon.myfragments

data class Student(
    val name: String,
    val id: String,
    val image: String,
    val yearLevel: String? = null,
    val course: String? = null,
    val age: Int = 0
)
